/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author pakal
 */
public class generar_graficas {
     public static void graficarBarra(String titulo, ArrayList<String> ejeX, ArrayList<Float> ejeY, String tituloX, String tituloY) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < ejeX.size(); i++) {
            dataset.addValue(ejeY.get(i), tituloY, ejeX.get(i).toString());
        }

        JFreeChart chart = ChartFactory.createBarChart(titulo, tituloX, tituloY, dataset);

        try {
            BufferedImage image = chart.createBufferedImage(462, 360);
            File file = new File("grafico.png");
            ChartUtilities.saveChartAsPNG(file, chart,462, 360);
             cosaspublicas.imagePaths.add(file.getAbsolutePath()); 
            System.out.println("Gráfico guardado como: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar el gráfico: " + e.getMessage());
        }
    }
    
    public static void graficarPie(String titulo, ArrayList<Float> values, ArrayList<String> labels) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (int i = 0; i < values.size(); i++) {
            dataset.setValue(labels.get(i), values.get(i));
        }

        JFreeChart chart = ChartFactory.createPieChart(titulo, dataset, true, true, false);
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {2}"));
        try {
            BufferedImage image = chart.createBufferedImage(462, 360);
            File file = new File("grafico_pie.png");
            ChartUtilities.saveChartAsPNG(file, chart, 462, 360);
             cosaspublicas.imagePaths.add(file.getAbsolutePath());
            System.out.println("Gráfico de Pie guardado como: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar el gráfico de Pie: " + e.getMessage());
        }
    }
    
    public static void graficarLinea(String titulo, String tituloX, String tituloY, ArrayList<String> ejeX, ArrayList<Float> ejeY) {
        XYSeries series = new XYSeries("Datos");
            Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < ejeX.size(); i++) {
             // Convertir las etiquetas de texto a valores numéricos (0, 1, 2, ...)
            indexMap.put(ejeX.get(i), i);
             series.add(i, ejeY.get(i));
         }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(titulo, tituloX, tituloY, dataset);
        // Establecer el personalizador de etiquetas del eje X
    chart.getXYPlot().setDomainAxis(new SymbolAxis(tituloX, ejeX.toArray(new String[0])));

        try {
            BufferedImage image = chart.createBufferedImage(462, 360);
            File file = new File("grafico_linea.png");
            ChartUtilities.saveChartAsPNG(file, chart, 462, 360);
             cosaspublicas.imagePaths.add(file.getAbsolutePath());
            System.out.println("Gráfico de Línea guardado como: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar el gráfico de Línea: " + e.getMessage());
        }
    }
        public static void graficarHistograma(String titulo, ArrayList<Float> values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Calcular la frecuencia de cada valor
        Map<Float, Integer> frequencies = new HashMap<>();
        for (Float value : values) {
            frequencies.put(value, frequencies.getOrDefault(value, 0) + 1);
        }

        // Agregar los valores y sus frecuencias al dataset
        for (Float value : frequencies.keySet()) {
            dataset.addValue(frequencies.get(value), "Frecuencia", String.valueOf(value));
        }

        JFreeChart chart = ChartFactory.createBarChart(titulo, "Valor", "Frecuencia", dataset);

        try {
            BufferedImage image = chart.createBufferedImage(462, 360);
            File file = new File("histograma.png");
            ChartUtilities.saveChartAsPNG(file, chart, 462, 360);
            cosaspublicas.imagePaths.add(file.getAbsolutePath());
            System.out.println("Histograma guardado como: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al guardar el histograma: " + e.getMessage());
        }
    }
        public static String createFrequencyTable(ArrayList<Float> numbers) {
        // Calcular la frecuencia de cada número
        Map<Float, Integer> frequencyMap = new HashMap<>();
        for (float number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        // Crear el StringBuilder para la tabla
        StringBuilder table = new StringBuilder();
        // Agregar el título de la tabla
        table.append("\nAnálisis de Arreglo\n");
        // Agregar los nombres de las columnas
        table.append(String.format("%-10s %-10s %-20s %-20s\n", "Valor", "F", "FA", "FR"));
        // Calcular los totales
        int totalFrequency = 0;
        int totalAbsoluteFrequency = 0;
        float totalRelativeFrequency = 0;
        // Recorrer el HashMap y agregar cada fila a la tabla
        for (Map.Entry<Float, Integer> entry : frequencyMap.entrySet()) {
            float value = entry.getKey();
            int frequency = entry.getValue();
            totalAbsoluteFrequency += frequency;
            float relativeFrequency = (float) frequency / numbers.size();
            table.append(String.format("%-10.2f %-10d %-20d %-20.2f\n", value, frequency, totalAbsoluteFrequency, relativeFrequency));
            totalFrequency += frequency;
            totalRelativeFrequency += relativeFrequency;
        }
        // Agregar los totales a la tabla
        table.append(String.format("%-10s %-10d %-20d %-20.2f\n", "Total", totalFrequency, totalAbsoluteFrequency, totalRelativeFrequency));
        return table.toString();
    }
   
}
