package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.company.StaticView.screenSize;
import static com.company.Texture.*;

public class Turtle extends JPanel{

    //private final
    ButtonExpandListener buttonListener;
    RecursiveLsys lsys;
    Graphics2D g2d;
    Texture texture;
    ArrayList<NonTerminal> listOfNT;
    NonTerminal nt;

    ExpandNodeMouseListener expandNodeMouseListener;
    private Map<NonTerminal,Point> testHashMap;


    static int screenWidth = (int) screenSize.getWidth();
    static int middleX = screenWidth/2;
    static int screenHeight = (int) screenSize.getHeight();
    private static final int BRANCH_HEIGHT = -50;
    AffineTransform originalTrans = AffineTransform.getTranslateInstance(middleX,screenHeight-60);
    ArrayList<AffineTransform> subTrees = new ArrayList<AffineTransform>();

    ArrayList<JButton> buttonList = new ArrayList<JButton>();

    public Turtle(RecursiveLsys lsys) {
        super();
        setFocusable(true);
        this.lsys = lsys;
        System.out.println("Jeg er træet, der tegnes: "+lsys.getTree());
        makeButtons();
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
        g2d = (Graphics2D) g.create();
        makeBackground(g2d);
        g2d.setTransform(originalTrans);

        for (int i = 0; i < lsys.getTree().length(); i++) {
            char currentCheck = lsys.getTree().charAt(i);

            switch (currentCheck) {
                case 'F':
                    growBranch(g2d);
                    
                    break;
                case 'K':
                    makeLog(g2d);
                    break;
                case 'A':
                    drawNonTerminal(g2d);

               //     interpretNonTerminal(g2d, i,  currentCheck);
                    break;
                case '+':
                    rotateRight(g2d);
                    break;
                case '-':
                    rotateLeft(g2d);
                    break;
                case '[':
                    push(g2d);
                    break;
                case ']':
                    pop(g2d);
                    break;
                default:
                    System.out.println("Char not in alphabet");
                    break;
            }
        }
        repaint();
        requestFocus();
    }


    private void interpretNonTerminal(Graphics2D g2d, int i, char a) {

        AffineTransform curTf = g2d.getTransform();
        int x = (int) curTf.getTranslateX();
        int y = (int) curTf.getTranslateY();
        JButton but = new JButton();
        but.setBackground(Color.MAGENTA);
        buttonListener = new ButtonExpandListener(lsys, i, a);
        but.addActionListener(buttonListener);

        but.setBounds(x,y,10,10);
        add(but);
    }
    private void push(Graphics2D g2d) {
        subTrees.add(g2d.getTransform());
    }
    private void pop(Graphics2D g2d) {
        AffineTransform t = subTrees.get(subTrees.size()-1);
        g2d.setTransform(t);
        subTrees.remove(subTrees.size()-1);
    }
    private void growBranch(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(2.0f));

        g2d.drawLine(0,0,0, BRANCH_HEIGHT);
        g2d.translate(0,BRANCH_HEIGHT);
       // drawLeafs(g2d); //draw Leafs bliver ikke kaldt i denne version, da vi skal rette nogle ting
    }

    private void drawLeafs(Graphics2D g2d) {
        //TODO: skal være object der får xpos og ypos for leaf ind. klasse til det er lavet ("Leaf")
        g2d.drawImage(leafImg, 0,-38,this);
        g2d.drawImage(leafImg, 0,-53,this);
        g2d.drawImage(leafImg,0,-17,this);
        g2d.drawImage(leafImg2, -27,-22,this);
        g2d.drawImage(leafImg2, -27,-40,this);
        g2d.drawImage(leafImg2, -27,-55,this);
        g2d.drawImage(leafHigh,-15,BRANCH_HEIGHT-4,this);

    }
    private void rotateLeft(Graphics2D g2d) {
        g2d.rotate(Math.PI/6);
    }
    private void rotateRight(Graphics2D g2d) {
        g2d.rotate(-Math.PI/6);
    }
    private void makeLog(Graphics2D g2d) {
        GeneralPath logShape = new GeneralPath();
        final double points[][]= {
                { -2, -250}, {2, -250},
                { 6 ,-50}, { -6,-50 }
        };

        logShape.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            logShape.lineTo(points[k][0], points[k][1]);

        logShape.closePath();

        g2d.fill(logShape);
        g2d.translate(0,-250);


    }
    private void makeButtons() {
        Button leafbuttonGrow = new Button();
        leafbuttonGrow.setLocation(10, 100);
        leafbuttonGrow.setBackground(Color.green);
        leafbuttonGrow.setSize(50, 50);
        this.add(leafbuttonGrow);

        leafbuttonGrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("put texture on tree");
                Texture texture = new Texture(true);
            }
        });
        Button leafbuttonKill = new Button();
        leafbuttonKill.setLocation(10, 160);
        leafbuttonKill.setBackground(Color.black);
        leafbuttonKill.setSize(50, 50);
        this.add(leafbuttonKill);
        leafbuttonKill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("remove texture on tree");
                Texture texture = new Texture(false);
            }
        });
    }
    private void makeBackground(Graphics2D turtle) {
        turtle.drawImage(backImg,0,0,screenWidth,screenHeight, this); //backgroundIMG. placed on position 0,0 - and scaled to fit screensize
        turtle.setPaint(Texture.soilTex); //sets the soil texture
        turtle.setColor(Color.BLACK);
        turtle.setPaint(Texture.barkTex);

    }

    public void drawNonTerminal(Graphics2D g2d){
        AffineTransform affineTransform = new AffineTransform();
        nt = new NonTerminal(g2d, affineTransform);//, affineTransform);
        listOfNT.add(nt);
    }

    public void ntClicked(int mouseX, int mouseY) {

        for (NonTerminal nt : listOfNT ) {
            System.out.println("Jeg er musse-x koordninat: "+mouseX+" jeg er cirkelcenter : ");
            System.out.println("Jeg er musse-y koordninat: "+mouseY+" jeg er cirkelcenter : ");
            System.out.println(nt.getNtCircle().getY());
            if (nt.getNtCircle().contains(mouseX,mouseY) == true){
                System.out.println("works");
            }
            else {
                System.out.println("Jeg er ikke inde i cirklen");
            }
        }

    }

    /*private void drawNonTerminal(Graphics2D g2d) {
        AffineTransform tf = g2d.getTransform();
        NonTerminal nt = new NonTerminal(g2d, tf);
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
