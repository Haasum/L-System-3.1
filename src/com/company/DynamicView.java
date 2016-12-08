package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.company.StaticView.MENU_WIDTH;
import static com.company.StaticView.screenSize;
import static com.company.Texture.*;

public class DynamicView extends JPanel{

    //private final
    ButtonExpandListener buttonListener;
    RecursiveLsys lsys;
    Graphics2D turtle;
    Graphics2D g2d;
    Texture texture;
    ArrayList<NonTerminal> listOfNT;
    NonTerminal nt;
    ButtonExpandListener buttonExpandListener;

    ExpandNodeMouseListener expandNodeMouseListener;
    private Map<NonTerminal,Point> testHashMap;


    static int screenWidth = (int) screenSize.getWidth();
    static int middleX = (screenWidth-MENU_WIDTH)/2;
    static int screenHeight = (int) screenSize.getHeight();
    private static final int BRANCH_HEIGHT = -40;
    AffineTransform originalTrans = AffineTransform.getTranslateInstance(middleX,screenHeight-160);
    ArrayList<AffineTransform> subTrees = new ArrayList<AffineTransform>();

    ArrayList<JButton> buttonList = new ArrayList<JButton>();

    public DynamicView(RecursiveLsys lsys) {
        super();
        setFocusable(true);
        this.lsys = lsys;
        System.out.println("Jeg er træet, der tegnes: "+lsys.getTree());

        makeMouseListener();
        testHashMap = new HashMap<>();
        listOfNT = new ArrayList<NonTerminal>();

    }

    private void makeMouseListener() {
     expandNodeMouseListener = new ExpandNodeMouseListener(this);
    }


    public void getNonTerminals(){
        for (int i = 0; i < lsys.getTree().length(); i++) {
            char currentCheck = lsys.getTree().charAt(i);
            if(currentCheck == 'A'){
                JButton but = new JButton();
                buttonList.add(but);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        listOfNT.clear();
        testHashMap.clear();
        super.paintComponent(g);

        turtle = (Graphics2D) g.create();
        g2d = (Graphics2D) g.create();

        makeBackground(turtle);

        turtle.setTransform(originalTrans);


        for (int i = 0; i < lsys.getTree().length(); i++) {
            char currentCheck = lsys.getTree().charAt(i);

            switch (currentCheck) {
                case 'F':
                    growBranch(turtle);
                    break;
                case 'K': // TODO: skal nok være if sætning, hvis det er det første F, skal det være en stamme. bare et forslag. hilsen naja
                    makeLog(turtle);
                    break;
                case 'A':
                    drawNonTerminal(turtle, g2d, i, currentCheck);
                    break;
                case '+':
                    rotateRight(turtle);
                    break;
                case '-':
                    rotateLeft(turtle);
                    break;
                case '[':
                    push(turtle);
                    break;
                case ']':
                    pop(turtle);
                    break;
                default:
                    System.out.println("Char not in alphabet");
                    break;
            }
        }
        repaint();
        requestFocus();
    }


    private void interpretNonTerminal(Graphics2D turtle, int i, char a) {

        AffineTransform curTf = turtle.getTransform();
        int x = (int) curTf.getTranslateX();
        int y = (int) curTf.getTranslateY();
        JButton but = new JButton();
        but.setBackground(Color.MAGENTA);
        but.addActionListener(buttonListener);

        but.setBounds(x,y,10,10);
        add(but);
    }
    private void push(Graphics2D turtle) {
        subTrees.add(turtle.getTransform());
    }
    private void pop(Graphics2D turtle) {
        AffineTransform t = subTrees.get(subTrees.size()-1);
        turtle.setTransform(t);
        subTrees.remove(subTrees.size()-1);
    }
    private void growBranch(Graphics2D turtle) {
        turtle.setStroke(new BasicStroke(2.0f));

        turtle.drawLine(0,0,0, BRANCH_HEIGHT);
        turtle.translate(0,BRANCH_HEIGHT);
      //  drawLeafs(turtle); //draw Leafs bliver ikke kaldt i denne version, da vi skal rette nogle ting
    }

    private void drawLeafs(Graphics2D turtle) {
        //TODO: skal være object der får xpos og ypos for leaf ind. klasse til det er lavet ("Leaf")
        turtle.drawImage(leafImg, 0,-38,this);
        turtle.drawImage(leafImg, 0,-53,this);
        turtle.drawImage(leafImg,0,-17,this);
        turtle.drawImage(leafImg2, -27,-22,this);
        turtle.drawImage(leafImg2, -27,-40,this);
        turtle.drawImage(leafImg2, -27,-55,this);
        turtle.drawImage(leafHigh,-15,BRANCH_HEIGHT-4,this);

    }
    private void rotateLeft(Graphics2D turtle) {
        turtle.rotate(Math.PI/8);
    }
    private void rotateRight(Graphics2D turtle) {
        turtle.rotate(-Math.PI/8);
    }
    private void makeLog(Graphics2D turtle) {
        GeneralPath logShape = new GeneralPath();
        final double points[][]= {
                { -2, -250}, {2, -250},
                { 6 ,-50}, { -6,-50 }
        };

        logShape.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            logShape.lineTo(points[k][0], points[k][1]);

        logShape.closePath();

        turtle.fill(logShape);
        turtle.translate(0,-250);


    }

    private void makeBackground(Graphics2D turtle) {
        turtle.drawImage(backImg,0,0,screenWidth,screenHeight, this); //backgroundIMG. placed on position 0,0 - and scaled to fit screensize
        turtle.setPaint(Texture.soilTex); //sets the soil texture
        turtle.setColor(Color.BLACK);
        turtle.setPaint(Texture.barkTex);

    }

    public void drawNonTerminal(Graphics2D turtle, Graphics2D g2dd,int i, char c){
        AffineTransform newTransform = turtle.getTransform();
        nt = new NonTerminal(g2dd, newTransform, this, i, c);//, affineTransform);
        listOfNT.add(nt);
    }

    public void ntClicked(int mouseX, int mouseY) {

        ArrayList<NonTerminal> ntArray = new ArrayList<NonTerminal>();


        for (NonTerminal nt : listOfNT ) {

            if (nt.getNtCircle().contains(mouseX,mouseY) == true){
                System.out.println("jeg er inde i en cirkel");
                ntArray.add(nt);
                //expandNode(nt);
            }
            else {

            }
            expandNode(ntArray);
        }

    }

    private void expandNode(ArrayList ntArray) {

        for (int i = 0; i < ntArray.size(); i++) {
            new ButtonExpandListener((NonTerminal) ntArray.get(i), lsys);
        }



    }

    /*private void drawNonTerminal(Graphics2D turtle) {
        AffineTransform tf = turtle.getTransform();
        NonTerminal nt = new NonTerminal(turtle, tf);
        testHashMap.put(nt, nt.getP());
        setTestHashMap(testHashMap);

    }
    public Map<NonTerminal, Point> getTestHashMap() {
        return testHashMap;
    }
    public void setTestHashMap(Map<NonTerminal, Point> testHashMap) {
        this.testHashMap = testHashMap;

    }*/
}
