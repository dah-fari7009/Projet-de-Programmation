import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Pair;

import java.util.Scanner;

public class ScorePane extends Pane {
    private Scores score;
    //private Label affichage;
    private VBox messages;

    public ScorePane(Scores s){
        super();
        getStyleClass().add("root");
        //setMinSize(500,500);
        score=s;
        //affichage=new Label();
        messages=new VBox();
        String sc="Scores";
        Label l=new Label(sc);
        l.getStyleClass().add("l");
        messages.getChildren().add(l);

        //messages.getStyleClass().add("messages");
        Rectangle2D r= Screen.getPrimary().getBounds();
        messages.setPrefSize(r.getWidth(),r.getHeight());
        messages.getStyleClass().add("mes");
        this.getChildren().add(messages);
        //messages.setAlignment(Pos.CENTER);
        getStylesheets().add("chat.css");
    }

    public void printScores(){
        //messages.getChildren().add(affichage);
        //affichage.setText(score.toString());
        //System.out.println("Je rentre dans printlScores");
        /*for(int i=0;i<score.length();i++){
            messages.getChildren().add(new Label("Nom "+i));
            System.out.println("J'essaie d'ajouter les messages");
            Pair<String,Integer> p=score.get(i);
            Label deb=new Label();
            deb.setText(p.getKey());
            deb.getStyleClass().add("deb");
            Label end=new Label();
            end.setText(p.getValue()+"");
            end.getStyleClass().add("end");
            HBox align=new HBox();
            align.getChildren().addAll(deb,end);
            messages.getChildren().add(align);
            }*/
            Scanner sc=new Scanner(score.toString());
            while(sc.hasNextLine())
                styleMessage(sc.nextLine());
            if(score.current!=null) {
                String scoreC = "Your score is : " + score.getCurrentScore();
                Label la = new Label(scoreC);
                la.getStyleClass().add("la");
                messages.getChildren().add(la);
            }
    }

    public void styleMessage(String str){
        String debut="";
        String fin="";
        boolean flag = true;
        for(int i=0; i<str.length(); i++){
            if(flag){
                if(str.charAt(i)=='-') flag=false;
                debut+=str.charAt(i)+"";
            }else fin+=str.charAt(i)+"";
        }
        Label deb=new Label(debut);
        deb.getStyleClass().add("deb");
        Label end=new Label(fin);
        end.getStyleClass().add("end");
        HBox align=new HBox();
        align.getChildren().addAll(deb,end);
        align.getStyleClass().add("align");
        messages.getChildren().add(align);
    }
}