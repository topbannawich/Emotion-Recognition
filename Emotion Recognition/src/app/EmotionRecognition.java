package app;

import org.json.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DropMode;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class EmotionRecognition {

	private JFrame frmEmotion;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 * @param aaa 
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmotionRecognition window = new EmotionRecognition();
					window.frmEmotion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public EmotionRecognition() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmotion = new JFrame();
		frmEmotion.setTitle("Emotion Recognition");
		frmEmotion.setResizable(false);
		frmEmotion.setBounds(100, 100, 696, 497);
		frmEmotion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmotion.getContentPane().setLayout(null);
		
		textField = new JTextField();

		textField.setBounds(140, 32, 404, 38);
		frmEmotion.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u0E25\u0E34\u0E07\u0E04\u0E4C\u0E23\u0E39\u0E1B\u0E20\u0E32\u0E1E");
		label.setBounds(61, 38, 85, 26);
		frmEmotion.getContentPane().add(label);
		
		JButton btnGo = new JButton("GO");
		btnGo.setAction(action);
		btnGo.setBounds(553, 40, 89, 23);
		frmEmotion.getContentPane().add(btnGo);
		
		JLabel lblExWwwxxxxxcomxxxxxjpg = new JLabel("ex: www.xxxxx.com/xxxxx.jpg");
		lblExWwwxxxxxcomxxxxxjpg.setBounds(150, 70, 184, 14);
		frmEmotion.getContentPane().add(lblExWwwxxxxxcomxxxxxjpg);
		
		JMenuBar menuBar = new JMenuBar();
		frmEmotion.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAbout = new JMenuItem("Developer");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bannawich Chaliewkriengkrai 5809650335\nChatchapat Suktakhu 5809650012\nParinya Tudjun 5809650160\nPiyanun Sasitivagorn 5809650541");
			}
		});
		mnFile.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		JMenuItem mntmAbout_1 = new JMenuItem("About");
		mntmAbout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "API Expire: 12/1/2018");
			}
		});
		mnFile.add(mntmAbout_1);
		mnFile.add(mntmExit);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "GO");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			String		aaa=textField.getText();
		
			JTextPane textPanenon = new JTextPane();
			
			JTextPane textPane = new JTextPane();
			textPane.setBounds(36, 83, 622, 354);
			frmEmotion.getContentPane().add(textPane);
			
			HttpClient httpClient = new DefaultHttpClient();
			
			//
			        try
			        {
			            // NOTE: You must use the same region in your REST call as you used to obtain your subscription keys.
			            //   For example, if you obtained your subscription keys from westcentralus, replace "westus" in the 
			            //   URL below with "westcentralus".
			            URIBuilder uriBuilder = new URIBuilder("https://southeastasia.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceAttributes=emotion");

			            URI uri = uriBuilder.build();
			            HttpPost request = new HttpPost(uri);

			            // Request headers. Replace the example key below with your valid subscription key.
			            request.setHeader("Content-Type", "application/json");
			            request.setHeader("Ocp-Apim-Subscription-Key", "a96e78939d254502bcfb7a99196f006f");

			            // Request body. Replace the example URL below with the URL of the image you want to analyze.
			            StringEntity reqEntity = new StringEntity("{ \"url\": \""+aaa+"\" }");
			           // StringEntity reqEntity = new StringEntity("{ \"url\": \""+aaa+"\" }");
			            request.setEntity(reqEntity);

			            HttpResponse response = httpClient.execute(request);
			            HttpEntity entity = response.getEntity();
			            
			            
			            if (entity != null)
			            {
			            	
			            	  textPanenon.setText(EntityUtils.toString(entity));
			            	  String k =textPanenon.getText();
			            	 
			            	  String[] parts = k.split(":");
			            	  System.out.println(parts[9]);
			            	  String part8 = parts[7]; 
			            	  String part9 = parts[8]; 
			            	  String part10 = parts[9]; 
			            	  String part11 = parts[10]; 
			            	  String part12 = parts[11]; 
			            	  String part13 = parts[12]; 
			            	  String part14 = parts[13]; 
			            	  String part15 = parts[14]; 
			           
			            	  String [] last1 = part8.split(",");
			            	  String l1  = last1[0]; //anger 
			            	  String [] last2 = part9.split(",");
			            	  String l2 = last2[0]; //contempt
			            	  String [] last3 = part10.split(",");
			            	  String l3 = last3[0]; //disgust
			            	  String [] last4 = part11.split(",");
			            	  String l4 = last4[0]; //fear
			            	  String [] last5 = part12.split(",");
			            	  String l5 = last5[0]; //happiness
			            	  String [] last6 = part13.split(",");
			            	  String l6 = last6[0]; //neutral
			            	  String [] last7 = part14.split(",");
			            	  String l7 = last7[0]; //sadness
			            	  String [] last8 = part15.split("}");
			            	  String l8 = last8[0]; //surprise
//			            	  System.out.println(l3);
//			            	  System.out.println(l4);
//			            	  System.out.println(l5);
//			            	  System.out.println(l6);
			            	  float amount1=Float.parseFloat(l1);
			            	  float amount2=Float.parseFloat(l2);
			            	  float amount3=Float.parseFloat(l3);
			            	  float amount4=Float.parseFloat(l4);
			            	  float amount5=Float.parseFloat(l5);
			            	  float amount6=Float.parseFloat(l6);
			            	  float amount7=Float.parseFloat(l7);
			            	  float amount8=Float.parseFloat(l8);
			 
			            	  if(amount1 >amount2 &&amount1 >amount3&&amount1 >amount4&&amount1 >amount5&&amount1 >amount6&&amount1 >amount7&&amount1 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Anger");
			            	  }else if(amount2 >amount1 &&amount2 >amount3&&amount2 >amount4&&amount2 >amount5&&amount2 >amount6&&amount2 >amount7&&amount2 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Contempt");
			            	  }else if(amount3 >amount1 &&amount3 >amount2&&amount3 >amount4&&amount3 >amount5&&amount3 >amount6&&amount3 >amount7&&amount3 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Disgust");
			            	  }else if(amount4 >amount1 &&amount4 >amount2&&amount4 >amount3&&amount4 >amount5&&amount4 >amount6&&amount4 >amount7&&amount4 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Fear");
			            	  }else if(amount5 >amount1 &&amount5 >amount2&&amount5 >amount3&&amount5 >amount4&&amount5 >amount6&&amount5 >amount7&&amount5 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Happiness");
			            	  }else if(amount6 >amount1 &&amount6 >amount2&&amount6 >amount3&&amount6 >amount4&&amount6 >amount5&&amount6 >amount7&&amount6 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Neutral");
			            	  }else if(amount7 >amount1 &&amount7 >amount2&&amount7 >amount3&&amount7>amount4&&amount7 >amount5&&amount7 >amount6&&amount7 >amount8) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Sadness");
			            	  }else if(amount8 >amount1 &&amount8 >amount2&&amount8 >amount3&&amount8 >amount4&&amount8 >amount5&&amount8 >amount6&&amount8 >amount7) {
			            		  textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is Surprise");
			            	  }
			            	 // textPane.setText("Anger: "+amount1+"\n"+"Contempt: "+amount2+"\n"+"Disgust: "+amount3+"\n"+"Fear: "+amount4+"\n"+"Happiness: "+amount5+"\n"+"Neutral: "+amount6+"\n"+"Sadness: "+amount7+"\n"+"Surprise: "+amount8+"\n"+"Your Picture Emotion is");
			            }
			            
			        }
			        catch (Exception ex)
			        {
			            System.out.println(ex.getMessage());
			        }
			        
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}