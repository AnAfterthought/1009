package com.mygdx.game.KeyboardControl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter.OutputType;

public class KeyboardControlDAO {
	private static final String KEY_MAPPING_FILE = "key_mappings.json";

	public KeyboardControl getKeyboardControl() {
		String json_contents = "";
		File file = new File(KEY_MAPPING_FILE);
		try {
			FileReader file_reader = new FileReader(file);
			BufferedReader reader = new BufferedReader(file_reader);
			String line = null;
			while ((line = reader.readLine()) != null) {
				json_contents += line;
			}
			reader.close();
			file_reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return new Json().fromJson(KeyboardControl.class, json_contents);
	}

	public void saveKeyboardControl(KeyboardControl control) {
		Json json = new Json();
		json.setOutputType(OutputType.json);
		File file = new File(KEY_MAPPING_FILE);
		try {
			FileWriter file_writer = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(file_writer);
			json.toJson(control, KeyboardControl.class, writer);
			writer.close();
			file_writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
