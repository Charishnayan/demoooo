public class PieChartDemo extends Application {

    //PIE CHART DATA
    private ObservableList data;

    //MAIN EXECUTOR
    public static void main(String[] args) {
        Application.launch(PieChartDemo.class, args);
    }

    //CONNECTION DATABASE SAVING DATA
    public void buildData(){
          Connection c ;
          data = FXCollections.observableArrayList();
          try{
            c = DBConnect.connect();
            //SQL FOR SELECTING NATIONALITY OF CUSTOMER
            String SQL = "SELECT COUNT(nationality_id), "
                    + "type FROM CUSTOMER c,NATIONALITY na"
                    + " WHERE na.id=c.nationality_id GROUP BY type";

            ResultSet rs = c.createStatement().executeQuery(SQL);
            while(rs.next()){
                //adding data on piechart data
                data.add(new PieChart.Data(rs.getString(2),rs.getDouble(1)));
            }
          }catch(Exception e){
              System.out.println("Error on DB connection");
              return;
          }

      }

      @Override
      public void start(Stage stage) throws Exception {
        //PIE CHART
        PieChart pieChart = new PieChart();
        buildData();
        pieChart.getData().addAll(data);

        //Main Scene
        Scene scene = new Scene(pieChart);        

        stage.setScene(scene);
        stage.setVisible(true);
      }
}