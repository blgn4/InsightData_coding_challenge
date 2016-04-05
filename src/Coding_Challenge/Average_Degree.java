package Coding_Challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Average_Degree {
	
	public String testInputOutputs(String input_file_path, String output_file_path)
	{
		 StringBuilder avg_degrees_result = new StringBuilder();
		try{
			FileWriter fw =new FileWriter(output_file_path);
			File f= new File(input_file_path);
			GraphBuilder gb = new GraphBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
			String line;
			while((line=br.readLine())!=null)
			{
				gb.processTweet(line);
				avg_degrees_result.append(gb.calculateDegree(fw)+" ");
			}
			fw.flush();
			fw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return avg_degrees_result.toString();
	}
	public static void main(String[] args)
	{
		Average_Degree ad = new Average_Degree();
		String input_file_path = "tweet_input/tweets.txt";
		String output_file_path = "tweet_output/output.txt";
		GraphBuilder gb = new GraphBuilder();
		try{
			FileWriter fw =new FileWriter(output_file_path);
			File f= new File(input_file_path);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF-8"));
			String line;
			while((line=br.readLine())!=null)
			{
				gb.processTweet(line);
				gb.calculateDegree(fw);
			}
			fw.flush();
			fw.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
