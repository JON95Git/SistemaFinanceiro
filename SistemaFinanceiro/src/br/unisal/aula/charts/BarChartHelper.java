/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.aula.charts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author lab4l
 */
public class BarChartHelper {
    
   private BarChartHelper() {}
    
   public static void criar(String[] legendas, double[] valores, JPanel painel){
       
       DefaultCategoryDataset dados = new DefaultCategoryDataset();
       
       for (int i = 0; i < valores.length; i++){
           dados.addValue(valores[i],legendas[i],"");
       }
       
       JFreeChart grafico = ChartFactory.createBarChart(
               null, null, null, //Título, legenda x, legenda y
               dados, PlotOrientation.VERTICAL, 
               true, true, true); //legenda, dicas, urls
       
       
       CategoryPlot desenho = grafico.getCategoryPlot();
       desenho.setBackgroundPaint(new Color(255,255,0));
       
       Paint[] colors = {
           new Color (100,150,15),
           new Color (200,100,85),
           new Color (25,83,128),
       };
       
       for (int i = 0; i< colors.length; i++){
           desenho.getRenderer().setSeriesPaint(i, colors[i]);
       }
       
       ChartPanel painelGrafico = new ChartPanel(grafico);
       painel.removeAll();
       painel.setLayout(new BorderLayout());
       painel.add(painelGrafico, BorderLayout.CENTER);
       painel.validate();
       
       try {
           OutputStream arquivo = new FileOutputStream("grafico barras.png");
           ChartUtilities.writeChartAsPNG(arquivo, grafico, 500, 350);   
       }catch (IOException ex){
           ex.printStackTrace();
       }
       
       
   }

   
    
}
