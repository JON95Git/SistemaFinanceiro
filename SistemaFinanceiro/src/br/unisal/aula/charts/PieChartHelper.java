package br.unisal.aula.charts;

import br.unisal.models.ItemFinanceiro;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChartHelper {

    private PieChartHelper() {
    }

    public static void criar(ArrayList<ItemFinanceiro> lista, String[] categorias, JPanel painel) {

        //Chave --> valor
        HashMap<String, Double> mapa = new HashMap<>();

        for (int i = 0; i < categorias.length; i++) {
            mapa.put(categorias[i], 0.0);
        }

        for (int i = 0; i < lista.size(); i++) {
            ItemFinanceiro item = lista.get(i);
            if (item.getTipo().toUpperCase().equals("DESPESA")) {
                String categoria = item.getCategoria();
                Double valorItem = item.getValor();
                Double valorAtual = mapa.get(categoria);
                valorAtual += valorItem;
                mapa.put(categoria, valorAtual);
            }

        }

        DefaultPieDataset dados = new DefaultPieDataset();
        for (int i = 0; i < categorias.length; i++) {
            String categoria = categorias[i];
            dados.setValue(categoria, mapa.get(categoria));

        }

        JFreeChart grafico = ChartFactory.createPieChart(
                "Despesas x Categorias", dados, true, true, false);


        PieSectionLabelGenerator label = new StandardPieSectionLabelGenerator(
                "{0} : ({2})",
                new DecimalFormat("0"),
                new DecimalFormat("0%"));

        PiePlot desenho = (PiePlot)grafico.getPlot();
        desenho.setLabelGenerator(label);

        ChartPanel painelGrafico = new ChartPanel(grafico);
        painel.removeAll();
        painel.setLayout(new BorderLayout());
        painel.add(painelGrafico, BorderLayout.CENTER);
        painel.validate();
    }
}
