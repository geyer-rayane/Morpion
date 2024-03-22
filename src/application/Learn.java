package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class Learn {

	@FXML
	private TextField TextField;
	@FXML
	private ProgressIndicator ProgressBar;

	@FXML
	private Button learn;

	public   void pressStartButton(int size, HashMap<Integer, Coup> mapTrain, int h, double lr, int l, boolean verbose,
			double epochs) {

		String directoryPath = "/home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/model";
		String filename = directoryPath.concat("/model_" + l + "_" + h + "_" + lr + ".txt");

		File modelFile = new File(filename);

		if (!modelFile.exists()) {
			System.out.println(filename);

			try {
				if (verbose) {
					System.out.println();
					System.out.println("START TRAINING ...");
					System.out.println();
				}

				int[] layers = new int[l + 2];
				layers[0] = size;
				for (int i = 0; i < l; i++) {
					layers[i + 1] = h;
				}
				layers[layers.length - 1] = size;

				double error = 0.0;
				MultiLayerPerceptron net = new MultiLayerPerceptron(layers, lr, new SigmoidalTransferFunction());

				if (verbose) {
					System.out.println("---");
					System.out.println("Load data ...");
					System.out.println("---");
				}

				javafx.concurrent.Task<MultiLayerPerceptron> task = new Task<MultiLayerPerceptron>() {

					@Override
					protected MultiLayerPerceptron call() throws Exception {
						double error = 0.0;
						double bestError = 1000;
						for (int i = 0; i < epochs; i++) {
							Coup c = mapTrain.get((int) (Math.random() * mapTrain.size()));
							double e = net.backPropagate(c.in, c.out);
							updateProgress(i, epochs);
							if (bestError > e) {
								bestError = e;
								if (i != 0 && i % 10 == 0 && verbose) {
									updateMessage("En cours " + i + " Best error : " + bestError / (double) i);
								}
							}
							error += e;
						}

						if (verbose) {
							// updateMessage("Learning completed!");
							System.out.println("Learning fini ! ");
						}

						net.save(filename);
						return net;
					}

				};
				ProgressBar.progressProperty().bind(task.progressProperty());

				// Liaison de la propriété message de la tâche au texte du TextField
				task.messageProperty().addListener(new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						TextField.setText(newValue);
					}
				});
				new Thread(task).start();
			}

			finally {
			}
		}

	}

	public static HashMap<Integer, Coup> loadCoupsFromFile(String file) {
		System.out.println("loadCoupsFromFile from " + file + " ...");
		HashMap<Integer, Coup> map = new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
			String s = "";
			while ((s = br.readLine()) != null) {
				String[] sIn = s.split("\t")[0].split(" ");
				String[] sOut = s.split("\t")[1].split(" ");

				double[] in = new double[sIn.length];
				double[] out = new double[sOut.length];

				for (int i = 0; i < sIn.length; i++) {
					in[i] = Double.parseDouble(sIn[i]);
				}

				for (int i = 0; i < sOut.length; i++) {
					out[i] = Double.parseDouble(sOut[i]);
				}

				Coup c = new Coup(9, "");
				c.in = in;
				c.out = out;
				map.put(map.size(), c);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Test.loadCoupsFromFile()");
			e.printStackTrace();
			System.exit(-1);
		}
		return map;
	}

	@FXML
	void play(ActionEvent event) {
		int size = 9;
		HashMap<Integer, Coup> mapTrain = loadCoupsFromFile(
				"/home/nas-wks01/users/uapv2200060/eclipse-workspace/MorpionProjet/src/application/train.txt");
		int h = 256;
		double lr = 0.01; // taux d'apprentissage
		int l = 1; // nombre de couches cachées
		boolean verbose = true;
		double epochs = 10000;

		pressStartButton(size, mapTrain, h, lr, l, verbose, epochs);

	}
	
}
