package _03_To_Do_List;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	
	JFrame frame = new JFrame("Program!!!");
	
	JPanel panel = new JPanel();
	
	JButton addTask = new JButton("Add Task");
	JButton viewTask = new JButton("View Tasks");
	JButton removeTask = new JButton("Remove Task");
	JButton saveList = new JButton("Save List");
	JButton loadList = new JButton("Load List");
	
	ArrayList<String> tasks = new ArrayList<String>();
	
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.run();
	}
	
	public void run() {
		frame.add(panel);
		
		panel.add(addTask);
		panel.add(viewTask);
		panel.add(removeTask);
		panel.add(saveList);
		panel.add(loadList);
		
		addTask.addActionListener(this);
		viewTask.addActionListener(this);
		removeTask.addActionListener(this);
		saveList.addActionListener(this);
		loadList.addActionListener(this);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addTask) {
			String task = JOptionPane.showInputDialog("What is the task you would like to add?");
			tasks.add(task);
		}else if (e.getSource() == viewTask){
			String allTasks = "";
			for (String task : tasks) {
				allTasks = allTasks + task + "\n";
			}
			JOptionPane.showMessageDialog(null, allTasks);
		}else if (e.getSource() == removeTask) {
			String task = JOptionPane.showInputDialog("What task would you like to remove?");
			tasks.remove(task);
		}else if (e.getSource() == saveList) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/file.txt");
				for (String task : tasks) {
					for (char c : task.toCharArray()) {
						fw.append(c);
					}
					fw.append('\n');
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource() == loadList) {
			
		}
	}
}
