package 实验八Test;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Test {
	Stage barStage = new Stage();  
    final CategoryAxis xAxis = new CategoryAxis();  
    final NumberAxis yAxis = new NumberAxis();  
    xAxis.setLabel("成绩");  
    yAxis.setLabel("人数/(人)");  
    NewBarChart barChart = new NewBarChart(xAxis, yAxis);  
    barStage.setScene(new Scene(barChart));  
    btBarChart.setOnAction(e -> {  
//        barChart.setData("5", "5", "5", "5", "5");  
        if (tfOutStandingNumber.getText().trim().length()>0) {//若分析数据不为空  
            if (barChart.getScene() != null) {  
                barChart.getScene().setRoot(new VBox());  
            }  
            barChart.setData(tfOutStandingNumber.getText(), tfGoodNumber.getText(), tfMediumNumber.getText(), tfPassNumber.getText(), tfNotPassNumber.getText());  
            barStage.setScene(new Scene(barChart));  
            barStage.show();  
        }  
    });  

}  
}
