package Penaltý;
	
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;



import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.shape.Rectangle;


public class Oyun extends Application {
	Pane root;
	ImageView kaleci;
    ImageView solkaleci;
    ImageView saðkaleci;
    ImageView resims; 
    ImageView resim;
    ImageView kaçýr;
	ImageView top;
	ImageView futbolcu1;
	ImageView gols;
	ImageView res;

   int test = 0;
   int test1=1;
    Timer timer = new Timer(); //gol yazýsýnda zaman ayarlamak için
    boolean bool1,d,dq,bool2;
	
	@Override
	public void start(Stage primaryStage) {
		root = new Pane();
		Scene scene = new Scene(root,800,700,Color.DARKGREEN);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	
	
		Mataryel();
		Golsevinç();
		Kaçýrma();
		primaryStage.setScene(scene);//ekrana yansýmasý için
		primaryStage.show();
	    kaçýr.setVisible(false); //kaçýrdýn ekranda görünmez olmasýný saðlýyo
		gols.setVisible(false);
	}
		
	 
	
	public static void main(String[] args) {
		launch(args);// bütün yazdýðýn kodlarý çalýþmaya yarýyor.
	
	}
	
	  public void Mataryel(){
		  ArkaplanResim();
		  TabloÇizim(); 
		     KaleciÇizim();
		  TopÇizim();
		  futbolcuÇizim();
	 
	  
	}
	  
	 
	public class kale {
	    int pos;
	    Rectangle r;//dikdörtgen
	    public kale(Rectangle r, int pos){
	        this.r = r;
	        this.pos = pos;
	    }
	}
	public void ArkaplanResim() {
        Image arkaplan = new Image("/Resimler/Arkaplan.jpg");
        resim = new ImageView();
        resim.setFitHeight(700);
        resim.setFitWidth(800);
        resim.setImage(arkaplan);
        add(resim);
        


       
	}
	
	
	public void KaleciÇizim() {
		
		  kaleci = new ImageView("/resimler/kaleci.png");
		  kaleci.setFitHeight(160);
	      kaleci.setFitWidth(120);
		  kaleci.setTranslateX(350);
		  kaleci.setTranslateY(150);
	        add(kaleci);
	        
	        solkaleci = new ImageView("/resimler/kaleci3.png");
	        solkaleci.setFitHeight(160);
		    solkaleci.setFitWidth(120);
	        solkaleci.setTranslateX(350);
	        solkaleci.setTranslateY(150);
	        
	        saðkaleci = new ImageView("/resimler/kaleci 1.png");
	        saðkaleci.setFitHeight(160);
		    saðkaleci.setFitWidth(120);
	        saðkaleci.setTranslateX(350);
	        saðkaleci.setTranslateY(150);
	    
	}
	
	
	
	public void Kaçýrma() {

	kaçýr = new ImageView("/Resimler/KAÇIRDIN.png");
		kaçýr.setTranslateX(250);
		kaçýr.setTranslateY(200);
		
		add(kaçýr);
		
	}
	
	
	
	public void Golsevinç() {

	gols = new ImageView("/Resimler/Gol sevinci.png");
		gols.setTranslateX(250);
		gols.setTranslateY(200);
		
		add(gols);
	}
	
	 public void TopÇizim(){
	    
	       
	        top = new ImageView("/Resimler/top.png");
	        top.setFitHeight(50);
	        top.setFitWidth(50);
	        top.setTranslateX(400);
	        top.setTranslateY(600);
	        
	        add(top);
	 }
	 public void futbolcuÇizim(){
	        Image futbolcu = new Image("/Resimler/futbolcu.png");
	        futbolcu1 = new ImageView();
	        futbolcu1.setFitHeight(300);
	        futbolcu1.setFitWidth(400);
	        futbolcu1.setImage(futbolcu);
	        
	        futbolcu1.setTranslateX(140);
	        futbolcu1.setTranslateY(375);
	        add(futbolcu1);
	 }
	
	public void TabloÇizim(){
        
        Rectangle r = new Rectangle(0,0,800,325);
        kale c = new kale(r,0);
       Karar(c);
        c.r.setFill(Color.TRANSPARENT);
        add(c.r);
        
        int baþlangýç = 200;
        int genislik = 81;
        int uzunluk = 70;
             
        int sýra = 1;
        for(int i = 0 ; i< 5; i++){
            kale c1 = new kale(new Rectangle(baþlangýç,100,genislik,uzunluk),sýra);
            sýra++;
            kale c2 = new kale(new Rectangle(baþlangýç,170,genislik,uzunluk),sýra);
           sýra++;
            kale c3 =new kale(new Rectangle(baþlangýç,240,genislik,uzunluk),sýra);
            sýra++;
            Karar(c1);
           Karar(c2);
            Karar(c3);
            c1.r.setFill(Color.TRANSPARENT);
            c2.r.setFill(Color.TRANSPARENT);
            c3.r.setFill(Color.TRANSPARENT);
            c1.r.setStroke(Color.BLACK);
            c2.r.setStroke(Color.BLACK);//çerçeve
            c3.r.setStroke(Color.BLACK);
            add(c1.r);
            add(c2.r);
            add(c3.r);
            baþlangýç+=genislik;
        }
	 }
	 public void add(Node n){
		    root.getChildren().add(n);
		}
	 public void Karar(kale c){
	       c.r.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	       
	        
	           
	       
	          Kaleci nesne = new Kaleci(0);
	             int konum = nesne.Atlama();
	           KaleciAnimasyonu(konum);
	            TopHareket(c.pos);
	           
	             if(konum == c.pos || c.pos==0){
	             
	                   System.out.println("Kaçýrdýn!");
	              if(test1==1) { 
	            	  timer.scheduleAtFixedRate(task3, 1000, 1000);//kaçýrdýn yazýsý ekranda göstermek için
	      	        timer.scheduleAtFixedRate(task4, 3000, 3000);//kaçýrdýn yazýsýný tekrar görünmez yapmak için
	            	  test1++;
	              }
	              bool2=true;
	             }else{
	                 
	                 System.out.println("Goll");
	               
	            
	            if(test == 0) {
	            	  timer.scheduleAtFixedRate(task1, 1000, 1000);
	      	        timer.scheduleAtFixedRate(task2, 3000, 3000);
	            	test++;
	            }
	      bool1 = true;
	              
          
             
	             }
	      
	        }
	   
	    });	
	      
	       
	 }
	    public void KaleciAnimasyonu(int pozisyon){
	    

	        
	        int linex = 0;
	        int liney = 0;
	       
	        res = null;
	        switch(pozisyon){
	            case 1:
	                linex = 260;
	                liney = 150;
	                res = solkaleci;
	                break;
	             case 2:
	                linex = 260;
	                liney = 240;
	                res = solkaleci;
	                break;
	              case 3:
	                linex = 260;
	                liney = 310;
	                res = solkaleci;
	              break;
	                  //---
	                  case 4:
	                linex = 330;
	                liney = 150;
	                res = solkaleci;
	                break;
	             case 5:
	                linex = 330;
	                liney = 240;
	                res = solkaleci;
	                break;
	              case 6:
	                linex = 330;
	                liney = 310;
	                res = solkaleci;
	              break;
	                  
	                  
	                      case 7:
	                linex = 400;
	                liney = 150;
	                res = kaleci;
	                break;
	             case 8:
	                linex = 400;
	                liney = 240;
	                res = kaleci;
	                break;
	              case 9:
	                linex = 400;
	                liney = 310;
	                res = kaleci;
	              break;
	              case 10:
	                linex = 470;
	                liney = 150;
	                res = saðkaleci;
	              break;
	              case 11:
	                linex = 470;
	                liney = 240;
	                res = saðkaleci;
	              break;
	              case 12:
	                linex = 470;
	                liney = 310;
	                res = saðkaleci;
	              break;
	              case 13:
	                linex = 520;
	                liney = 150;
	                res = saðkaleci;
	              break;
	              case 14:
	                linex = 520;
	                liney = 240;
	                res = saðkaleci;
	              break;
	              case 15:
	                linex = 520;
	                liney = 310;
	                res = saðkaleci;
	              break;
	        
	        
	              
	        }
	      root.getChildren().remove(top);
	       root.getChildren().remove(kaleci);
	       root.getChildren().remove(solkaleci);
	       root.getChildren().remove(saðkaleci);
	     
	       
	       if(res !=null)
	       root.getChildren().add(res);
	      
	     PathElement[] gidis= 
	        {
	            new MoveTo(400, 230),new LineTo(linex, liney)//kaleci koordinatý	          
	        };
	          
	      root.getChildren().add(top);
	          Path yol = new Path();  
	       
	    
	        yol.getElements().addAll(gidis);
	         
	        PathTransition anim = new PathTransition();
	        anim.setNode(res);
	        anim.setPath(yol);
	     
	        anim.setDuration(new Duration(1500));
	       
	        anim.play();

	      
	    }
	     
	    
	    
	  
	       public void TopHareket(int pos){
	          
	           int moveToX = 0;
	           int moveToY = 0;
	           boolean ayar1 = false;
	           boolean ayar2 = true;
	           switch (pos){
	               case 0 :
	                   
	                   break;
	               case 1: 
	               moveToX = 235;
	               moveToY = 135;
	               ayar1 = true;
	               ayar2 = false;
	        
	               
	               break;
	               
	               case 2: 
	                   
	               moveToX = 235;
	               moveToY = 205;
	                ayar1 = true;
	               ayar2 = false;
	             
	               break;
	               
	               case 3: 
	                   
	               moveToX = 235;
	               moveToY = 275;
	               ayar1 = true;
	               ayar2 = false;
	            
	               break;
	                   
	               
	               case 4: 
	               moveToX = 316;
	               moveToY = 135;
	               ayar1 = true;
	               ayar2 = false;
	               break;
	               
	               case 5: 
	                   
	               moveToX = 316;
	               moveToY = 205;
	               ayar1 = true;
	               ayar2 = false;
	               break;
	               
	               case 6: 
	                   
	               moveToX = 316;
	               moveToY = 275;
	               ayar1 = true;
	               ayar2 = false;
	               break;
	               
	               case 7: 
	               moveToX = 397;
	               moveToY = 135;
	               break;
	               
	               case 8: 
	                   
	               moveToX = 397;
	               moveToY = 205;
	               break;
	               
	               case 9: 
	                   
	               moveToX = 397;
	               moveToY = 275;
	               break;
	               
	               case 10:
	               moveToX = 478;
	               moveToY = 135;
	               break;
	               
	               case 11: 
	               moveToX = 478;
	               moveToY = 205;
	               break;
	               
	               case 12: 
	                   
	               moveToX = 478;
	               moveToY = 275;
	               break;
	               
	               case 13:
	               moveToX = 559;
	               moveToY = 135;
	               break;
	               
	               case 14: 
	                   
	               moveToX = 559;
	               moveToY = 205;
	               break;
	               
	               case 15: 
	                   
	               moveToX = 559;
	               moveToY = 275;
	               break;
	           }
	            PathElement[] gidis= 
	         {
	            new MoveTo(425, 600),
	           
	            new ArcTo(100, 100, 100, moveToX, moveToY, ayar2, ayar1)//x,y,z ekseninde hareket
	            
	           
	           
	         };

	        Path yol = new Path();  
	        
	     
	     
	
	         yol.getElements().addAll(gidis);
	         PathTransition anim = new PathTransition();
	         anim.setNode(top);
	         anim.setPath(yol);
	      
	         anim.setDuration(new Duration(1500));
	        
	         anim.play();

		    
	      
	       }    
	
	
	       TimerTask task1 = new TimerTask()
	       
	       {
	               public void run()
	               {
	            	   if(bool1 == true) {
	            	gols.setVisible(true);
	            //   System.out.println("test"); 
	               d = true;
	            	   }
	               }

	       };
  TimerTask task2 = new TimerTask()
	       
	       {
	               public void run()
	               {
	            	  
	            	   if(d == true) {
	            	   gols.setVisible(false);
	            //   System.out.println("test"); 
	              d = false;
	               bool1 = false;
	            	   }
	               }

	       };
       TimerTask task3 = new TimerTask()
	       
	       {
	               public void run()
	               {
	            	   if(bool2 == true) {
	            	kaçýr.setVisible(true);
	              // System.out.println("test"); 
	               dq = true;
	            	   }
	               }

	       };
  TimerTask task4 = new TimerTask()
	       
	       {
	               public void run()
	               {
	            	  
	            	   if(dq == true) {
	            	kaçýr.setVisible(false);
	               //System.out.println("test"); 
	               dq = false;
	               bool2 = false;
	            	   }
	               }

	               
	       };

	       
}
 
	 
	 


    
    
    
    
    
    
