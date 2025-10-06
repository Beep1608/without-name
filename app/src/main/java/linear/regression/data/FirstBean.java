package linear.regression.data;

import com.opencsv.bean.CsvBindByName;



public class FirstBean {

    @CsvBindByName
    private String x;
    @CsvBindByName
    private String y;

    public void setX(String x){
        this.x = x;
    }

    public void setY(String y){
        this.y = y;
    }

    public String getX(){
        return x;
    }

    public String getY(){
        return y;
    }
}