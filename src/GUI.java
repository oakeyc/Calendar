import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
/**
 * is the over-arching frame that interconnects the panels
 *  is a JFrame
 * @author courtney Oka
 * 6/10/14
 */
public class GUI extends JFrame//this'll be fun
{
	private CalendarPanel cal;
	private SidePanel side;
	private BottomPanel bot;
	private WordsPanel word;

	/**
	 * ctor
	 * makes new panels and adds them
	 * creates a layout
	 */
	public GUI()  // putting all the stuff in here :)
	{
		setTitle("Your Calendar");
		setSize(800,800);
		setMinimumSize(new Dimension(400,400));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		cal = new CalendarPanel(this);
		cal.setBackground(Color.CYAN);		

		side = new SidePanel(this);
		side.setBackground(Color.MAGENTA);

		bot = new BottomPanel(this);
		bot.setBackground(new Color(18,44,238));

		word = new WordsPanel(this);

		JPanel contentPane = new JPanel(new BorderLayout());
		JPanel contentPane2 = new JPanel(new BorderLayout());
		contentPane.add(cal, BorderLayout.CENTER);
		contentPane.add(word, BorderLayout.NORTH);
		contentPane2.add(contentPane, BorderLayout.CENTER);
		contentPane2.add(side, BorderLayout.EAST);
		contentPane2.add(bot, BorderLayout.SOUTH);

		add(contentPane2);
		setVisible(true);
	}

	/**
	 * @return the cal
	 */
	public CalendarPanel getCal() {
		return cal;
	}

	/**
	 * @param cal the cal to set
	 */
	public void setCal(CalendarPanel cal) {
		this.cal = cal;
	}

	/**
	 * @return the side
	 */
	public SidePanel getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(SidePanel side) {
		this.side = side;
	}

	/**
	 * @return the bot
	 */
	public BottomPanel getBot() {
		return bot;
	}

	/**
	 * @param bot the bot to set
	 */
	public void setBot(BottomPanel bot) {
		this.bot = bot;
	}

	/**
	 * @return the word
	 */
	public WordsPanel getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(WordsPanel word) {
		this.word = word;
	}

	public static void main(String[] args)
	{
		GUI g = new GUI();
	}

}
