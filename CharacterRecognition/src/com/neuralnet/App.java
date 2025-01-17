package com.neuralnet;
import java.util.Arrays;
public class App {
	public static void main(String[] args) throws Exception {
		
		float[][] trainingData = new float[][] {
			 new float[] {0,0,1,1,1,1,0,0,0,1,1,0,0,1,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0},
			 new float[] {1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1},
			 new float[] {0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
			 new float[] {0,0,1,1,0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,0,1,1,1,1,1,0,0,1,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,0,1,1,0,0,0,0,1},
			 new float[] {0,1,1,0,0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,1,0,1,0,0,0,1,1,1,1,1,0},
			 new float[] {0,0,0,0,1,1,0,0,1,0,0,1,1,1,0,0,0,0,1,1,0,1,0,0,0,1,1,0,0,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},
			 new float[] {1,1,1,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,0,0,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0},
			 new float[] {0,0,1,1,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,0,0,1,1,1,1,0,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,1,0,0,0,1,0,1,0,1,1,0,0,1,1,1,0,0,1,0,0,1,1,0},
			 new float[] {1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,1,0,1,1,1,0,0,1,1,1,1,0,1,0,0,1,1,1,0,0,1,0,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,1,1,0,1,0,0,0},
			 new float[] {0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0},
			 new float[] {0,1,1,1,0,0,0,1,1,1,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,0,1,0,0,1,1,1,0,1,1,0,0,1,0,1,1,1,1,1,1,1}
		};
		
		float[][] trainingResults = new float[][] {
			 new float[] {1,0,0,0,0,0,0,0,0,0}, // "0"
			 new float[] {1,0,0,0,0,0,0,0,0,0}, // "0"
			 new float[] {0,1,0,0,0,0,0,0,0,0},// "1"
			 new float[] {0,0,1,0,0,0,0,0,0,0},// "2"
			 new float[] {0,0,0,1,0,0,0,0,0,0},// "3"
			 new float[] {0,0,0,0,1,0,0,0,0,0},// "4"
			 new float[] {0,0,0,0,0,1,0,0,0,0},// "5"
			 new float[] {0,0,0,0,0,0,1,0,0,0},// "6"
			 new float[] {0,0,0,0,0,0,0,1,0,0},// "7"
			 new float[] {0,0,0,0,0,0,0,0,1,0},// "8"
			 new float[] {0,0,0,0,0,0,0,0,0,1}// "9"
		};
		
		BackpropNeuralNetwork backpropagationNeuralNetworks = new BackpropNeuralNetwork(64, 15, 10);
	
		for (int iterations = 0; iterations < NeuralNetConstants.ITERATIONS; iterations++) {
	
			for (int i = 0; i < trainingResults.length; i++) {
				backpropagationNeuralNetworks.train(trainingData[i], trainingResults[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
			}
	
			if ((iterations + 1) % 100 == 0) {
				System.out.println();
				for (int i = 0; i < trainingResults.length; i++) {
					float[] data = trainingData[i];
					float[] calculatedOutput = backpropagationNeuralNetworks.run(data);
					System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
				}
			}
		}		
	
		System.out.println("---------------------------");
		/*CharacterReader.readImage();
		float[] calculatedOutput = backpropagationNeuralNetworks.run(CharacterReader.pixelarray);
		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
		System.out.println("---------------------------");*/
		float[] calculatedOutput = backpropagationNeuralNetworks.run(new float[] {0,0,1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,1,0,0,1,1,0,0,0,1,1,1,1,0,0});
		System.out.println(calculatedOutput[0]+" "+calculatedOutput[1]+" "+calculatedOutput[2]+" "+calculatedOutput[3]+" "+calculatedOutput[4]+" "+calculatedOutput[5]+" "+calculatedOutput[6]+" "+calculatedOutput[7]+" "+calculatedOutput[8]+" "+calculatedOutput[9]);
		System.out.println("---------------------------");
		int character=10;
		float max=calculatedOutput[0];
		for(int i=0;i<10;i++){
			
				if(calculatedOutput[i]>max){
					max = calculatedOutput[i];
					character=i;
				}
			
		}
		if(character<10)
			System.out.println("Recognized character is "+character);
	}
}
