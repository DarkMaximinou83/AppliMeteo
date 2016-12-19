package View;



import Model.Complexe;
import Model.Echantillonage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by axel on 07/12/2016.
 */
public class Result implements ActionListener, Observer{

        private JFrame frame = null;
        private JPanel fPane = null;
        private JButton button = null;
        private Echantillonage echantillonage = null;
        private Integer nbEchantillonage  = null;
    public Result(Echantillonage echantillonage,Integer nbEchantillonage){
        this.echantillonage = echantillonage;

        this.nbEchantillonage = nbEchantillonage;

        buildFrame();
    }

    private void buildFrame() {
        int compt=0;
        frame = new JFrame();
        fPane = new JPanel();
        button = new JButton();
        JLabel label = new JLabel("Nombre d'échantillon par sec");
        fPane.add(label, BorderLayout.CENTER);

        button = new JButton("Quitter");
        fPane.add(button, BorderLayout.SOUTH);
        Complexe[][] tabComplexe = echantillonage.getMatrice();
        String[] tab=new String[1000];
        for(int j=0;j<echantillonage.getNbFenetre(); j++) {
            for (int i = 0; i < nbEchantillonage/2; i++) {
                //LOGGER.info(echantillonage.getMatrice()[j][i].toString());
                tab[compt] = echantillonage.getMatrice()[j][i].toString() ;
                System.out.println(echantillonage.getMatrice()[j][i].toString());
                compt++;
            }
        }
        JList list = new JList(tab); //data has type Object[]
        JScrollPane listScroller = new JScrollPane(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);


        listScroller.setPreferredSize(new Dimension(500, 200));
        fPane.add(listScroller, BorderLayout.CENTER);

        /*
        DefaultPieDataset data=new DefaultPieDataset();
    data.setValue("Category1",43.2);
    data.setValue("Category2",27.9);
    data.setValue("Category3",79.5);

    //create a chart...
    JFreeChart chart=ChartFactory.createPieChart( "SamplePieChart", data, true/legend?/,true/*tooltips?, falseURLs?);

        //create and display a frame...
        ChartFrame frame=new ChartFrame("First",chart);
         */
        button.addActionListener(this);
        frame.setContentPane(fPane);
        frame.setTitle("Projet Java Maths");
        frame.pack();
    }
    public void close() {

        frame.dispose();
    }

    public void display() {
        frame.setSize(600, 400);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //  this.controller.notifyVolumeChanged(Integer.parseInt(this.spinner.getValue().toString()));
        close();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {

            System.out.println("[Frame] : update");
        }
    }
}
