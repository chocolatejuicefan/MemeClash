import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

public class MemeClash extends JFrame {
    
    static class Card {
        final int id;
        final String name, emoji, category, rarity;
        final int power;
        final Color accent;

        Card(int id, String name, String emoji, String category, int power, String rarity, Color accent) {
            this.id = id; this.name = name; this.emoji = emoji;
            this.category = category; this.power = power;
            this.rarity = rarity; this.accent = accent;
        }
    }

    static final List<Card> ALL_CARDS = Arrays.asList(
        new Card(1,  "Distracted Boyfriend", "💏", "Meme Lord",    72, "epic",      new Color(155, 89,182)),
        new Card(2,  "Doge",                 "🐕", "OG Meme",      88, "legendary", new Color(255,215,  0)),
        new Card(3,  "This Is Fine Dog",     "🔥", "Meme Lord",    65, "rare",      new Color( 52,152,219)),
        new Card(4,  "Crying Cat",           "😿", "Meme Lord",    55, "common",    new Color(150,150,150)),
        new Card(5,  "Salt Bae",             "🧂", "Celebrity",    70, "rare",      new Color( 52,152,219)),
        new Card(6,  "Baby Yoda",            "👶", "Pop Culture",  91, "legendary", new Color(255,215,  0)),
        new Card(7,  "Hide the Pain Harold", "😬", "Meme Lord",    67, "rare",      new Color( 52,152,219)),
        new Card(8,  "Karen",                "💇", "Viral Villain",60, "common",    new Color(150,150,150)),
        new Card(9,  "Elon Musk Tweet",      "🐦", "Tech Chaos",   85, "epic",      new Color(155, 89,182)),
        new Card(10, "Among Us",             "🔴", "Gaming",       78, "epic",      new Color(155, 89,182)),
        new Card(11, "Giga Chad",            "💪", "Meme Lord",    95, "legendary", new Color(255,215,  0)),
        new Card(12, "Woman Yelling at Cat", "🐱", "Meme Lord",    80, "epic",      new Color(155, 89,182)),
        new Card(13, "Drake Approves",       "👍", "Hip Hop",      82, "epic",      new Color(155, 89,182)),
        new Card(14, "Bernie Mittens",       "🧤", "Political",    74, "rare",      new Color( 52,152,219)),
        new Card(15, "Harambe",              "🦍", "Legend",       89, "legendary", new Color(255,215,  0)),
        new Card(16, "Shrek",                "🧅", "Movie Icon",   83, "epic",      new Color(155, 89,182)),
        new Card(17, "Area 51 Raider",       "👽", "Viral Event",  58, "common",    new Color(150,150,150)),
        new Card(18, "Nyan Cat",             "🌈", "OG Meme",      76, "rare",      new Color( 52,152,219)),
        new Card(19, "SpongeBob Mocking",    "🧽", "Meme Lord",    77, "rare",      new Color( 52,152,219)),
        new Card(20, "Stonks Guy",           "📈", "Finance Bro",  68, "rare",      new Color( 52,152,219)),
        new Card(21, "OK Boomer",            "👴", "Gen Z",        62, "common",    new Color(150,150,150)),
        new Card(22, "Pepe the Frog",        "🐸", "OG Meme",      79, "epic",      new Color(155, 89,182)),
        new Card(23, "Rick Roll",            "🎵", "OG Meme",      87, "legendary", new Color(255,215,  0)),
        new Card(24, "Keanu Breathing",      "😲", "Meme Lord",    71, "rare",      new Color( 52,152,219)),
        new Card(25, "Ice Cube Friday",      "🧊", "Hip Hop",      73, "rare",      new Color( 52,152,219)),
        new Card(26, "Cardi B OMG",          "💅", "Celebrity",    81, "epic",      new Color(155, 89,182)),
        new Card(27, "NPC Gamer",            "🕹", "Gaming",       56, "common",    new Color(150,150,150)),
        new Card(28, "Side Eye Chloe",       "👧", "Meme Lord",    84, "epic",      new Color(155, 89,182)),
        new Card(29, "Dramatic Chipmunk",    "🐿", "OG Meme",      63, "common",    new Color(150,150,150)),
        new Card(30, "Math Lady",            "🤔", "Meme Lord",    69, "rare",      new Color( 52,152,219)),
        new Card(31, "Galaxy Brain",         "🧠", "Tech Chaos",   86, "legendary", new Color(255,215,  0)),
        new Card(32, "LeBron James",         "🏀", "Celebrity",    83, "legendary", new Color(255,215,  0)),
        new Card(33, "DJT",                  "👱", "Political",    74, "rare",      new Color( 52,152,219)),
        new Card(34, "NM",                   "⛓", "Political",    74, "rare",      new Color( 52,152,219)),
        new Card(35, "Messi",                "⚽", "Celebrity",    85, "legendary", new Color(255,215,  0)),
        new Card(36, "CR7",                  "🏅", "Celebrity",    85, "legendary", new Color(255,215,  0)),
        new Card(37, "John Cena",            "👊", "Celebrity",    87, "legendary", new Color(255,215,  0)),
        new Card(38, "DMX",                  "❌", "Hip Hop",      75, "rare",      new Color( 52,152,219)),
        new Card(39, "67 Kid",               "67", "Gen Z",        67, "common",    new Color(150,150,150)),
        new Card(40, "Orang",                "🟧", "Meme Lord",    68, "rare",      new Color( 52,152,219)),
        new Card(41, "Robin Rotten",         "🟪", "Pop Culture",  85, "legendary", new Color(255,215,  0)),
        new Card(42, "Sportacus",            "🤸", "Pop Culture",  86, "legendary", new Color(255,215,  0)),
        new Card(43, "Sonic",                "🦔", "Gaming",       88, "legendary", new Color(255,215,  0)),
        new Card(44, "Waluigi",              "👾", "Gaming",       79, "epic",      new Color(155, 89,182)),
        new Card(45, "Mario",                "🍄", "Gaming",       87, "legendary", new Color(255,215,  0)),
        new Card(46, "Travis Scott",         "🎤", "Hip Hop",      82, "epic",      new Color(155, 89,182)),
        new Card(47, "Jim Carrey",           "😜", "Legend",       74, "rare",      new Color( 52,152,219)),
        new Card(48, "Matt",                 "🏅", "Gaming",       79, "epic",      new Color(155, 89,182)),
        new Card(49, "Peter Griffin",        "🤓", "Pop Culture",  85, "legendary", new Color(255,215,  0)),
        new Card(50, "Starter Pack",         "📦", "Meme Lord",    57, "common",    new Color(150,150,150))
    );

    static final Color BG_DARK    = new Color(13, 13, 26);
    static final Color BG_PANEL   = new Color(26, 26, 46);
    static final Color BG_CARD    = new Color(22, 22, 40);
    static final Color GOLD       = new Color(255,215,  0);
    static final Color CYAN       = new Color(  0,212,255);
    static final Color RED_LIGHT  = new Color(255,107,107);
    static final Color GREEN_WIN  = new Color(  0,255,136);
    static final Color PURPLE     = new Color(155, 89,182);
    static final Color TEXT_MUTED = new Color(150,150,150);
    static final Color BORDER_DIM = new Color( 60, 60, 80);

    enum Phase  { START, PLAY, TAG, GAMEOVER }
    enum Result { NONE, P1_WIN, P2_WIN, P1_TAG, P2_TAG, DRAW_TAG, TIE }

    Phase  phase  = Phase.START;
    Result result = Result.NONE;

    List<Card> p1Hand = new ArrayList<>(), p2Hand = new ArrayList<>();
    Card p1Field, p2Field, p1Selected;
    List<Card> p1TagCards = new ArrayList<>(), p2TagCards = new ArrayList<>();
    int p1Score, p2Score, p1Power, p2Power, round, tagTurn;
    final int maxRounds = 16;
    List<String[]> logLines = new ArrayList<>();

    JPanel  mainPanel, battlePanel, scorePanel, logPanel, actionPanel;
    JPanel  handGrid, midPanel, tagBanner;
    JPanel  p1FieldPanel, p2FieldPanel;
    JButton playBtn, newGameBtn;
    JLabel  roundLabel, p1ScoreLabel, p2ScoreLabel, p1FinalLabel, p2FinalLabel;
    JLabel  resultLabel, vsBanner;
    JTextPane logPane;
    CardWidget p1FieldWidget, p2FieldWidget;
    Font fontMed, fontSmall, fontMono;

    // ── Constructor ───────────────────────────────────────────────
    public MemeClash() {
        setTitle("MemeClash! — Pop Culture Card Battle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 780);
        setMinimumSize(new Dimension(800, 650));
        setLocationRelativeTo(null);

        fontMed   = new Font("Dialog", Font.BOLD, 16);
        fontSmall = new Font("Dialog", Font.PLAIN, 12);
        fontMono  = new Font("Monospaced", Font.BOLD, 13);

        buildUI();
        setVisible(true);
        showStartScreen();
    }

    // ── UI Construction ───────────────────────────────────────────
    void buildUI() {
        mainPanel = new JPanel(new BorderLayout(8, 8));
        mainPanel.setBackground(BG_DARK);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
        setContentPane(mainPanel);

        JLabel title = new JLabel("⚡  MemeClash!  ⚡", SwingConstants.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 32));
        title.setForeground(GOLD);
        title.setBorder(BorderFactory.createEmptyBorder(0, 0, 4, 0));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel centerCol = new JPanel();
        centerCol.setLayout(new BoxLayout(centerCol, BoxLayout.Y_AXIS));
        centerCol.setBackground(BG_DARK);

        scorePanel = buildScorePanel();
        centerCol.add(scorePanel);
        centerCol.add(Box.createVerticalStrut(6));

        tagBanner = new JPanel();
        tagBanner.setBackground(new Color(80, 30, 100));
        tagBanner.setBorder(BorderFactory.createLineBorder(PURPLE, 2, true));
        JLabel tbl = new JLabel("⚡  TAG TEAM MATCH!  Pick your partner card!  ⚡", SwingConstants.CENTER);
        tbl.setFont(fontMed);
        tbl.setForeground(new Color(195,155,211));
        tagBanner.add(tbl);
        tagBanner.setVisible(false);
        tagBanner.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));
        centerCol.add(tagBanner);
        centerCol.add(Box.createVerticalStrut(4));

        battlePanel = buildBattlePanel();
        battlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 260));
        centerCol.add(battlePanel);
        centerCol.add(Box.createVerticalStrut(6));

        logPanel = buildLogPanel();
        logPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
        logPanel.setPreferredSize(new Dimension(0, 90));
        centerCol.add(logPanel);
        centerCol.add(Box.createVerticalStrut(6));

        mainPanel.add(centerCol, BorderLayout.CENTER);

        // ── Bottom panel ──────────────────────────────────────────
        JPanel bottomPanel = new JPanel(new BorderLayout(0, 6));
        bottomPanel.setBackground(BG_DARK);

        JLabel handLabel = new JLabel("YOUR HAND — click a card to select, then hit PLAY CARD");
        handLabel.setFont(fontSmall);
        handLabel.setForeground(TEXT_MUTED);
        handLabel.setBorder(BorderFactory.createEmptyBorder(0, 4, 2, 0));
        bottomPanel.add(handLabel, BorderLayout.NORTH);

        handGrid = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 4));
        handGrid.setBackground(BG_DARK);
        JScrollPane handScroll = new JScrollPane(handGrid);
        handScroll.setBackground(BG_DARK);
        handScroll.getViewport().setBackground(BG_DARK);
        handScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        handScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        handScroll.setBorder(BorderFactory.createLineBorder(BORDER_DIM));
        handScroll.setPreferredSize(new Dimension(0, 110));
        bottomPanel.add(handScroll, BorderLayout.CENTER);

        actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));
        actionPanel.setBackground(BG_DARK);

        playBtn = makeButton("PLAY CARD!", GOLD, Color.BLACK);
        playBtn.addActionListener(e -> onPlayCard());
        playBtn.setEnabled(false);

        newGameBtn = makeButton("NEW GAME", new Color(50,50,70), TEXT_MUTED);
        newGameBtn.addActionListener(e -> startGame());

        actionPanel.add(playBtn);
        actionPanel.add(newGameBtn);
        bottomPanel.add(actionPanel, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    JPanel buildScorePanel() {
        JPanel p = new JPanel(new GridLayout(1, 3, 10, 0));
        p.setBackground(BG_PANEL);
        p.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_DIM, 2, true),
            BorderFactory.createEmptyBorder(8, 14, 8, 14)));
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        JPanel p1 = new JPanel(new GridLayout(4,1,0,1)); p1.setBackground(BG_PANEL);
        JLabel l1 = lbl("YOUR SCORE", 11, TEXT_MUTED, false); l1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel n1 = lbl("YOU", 18, CYAN, true);               n1.setHorizontalAlignment(SwingConstants.CENTER);
        p1ScoreLabel = lbl("0 pts", 22, CYAN, true);           p1ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        p1FinalLabel = lbl("Final: 0", 11, TEXT_MUTED, false); p1FinalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(l1); p1.add(n1); p1.add(p1ScoreLabel); p1.add(p1FinalLabel);

        JPanel mid = new JPanel(new GridLayout(2,1,0,2)); mid.setBackground(BG_PANEL);
        JLabel rl = lbl("ROUND", 10, TEXT_MUTED, false); rl.setHorizontalAlignment(SwingConstants.CENTER);
        roundLabel = lbl("0 / 16", 24, GOLD, true);       roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mid.add(rl); mid.add(roundLabel);

        JPanel p2 = new JPanel(new GridLayout(4,1,0,1)); p2.setBackground(BG_PANEL);
        JLabel l2 = lbl("CPU SCORE", 11, TEXT_MUTED, false); l2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel n2 = lbl("CPU", 18, RED_LIGHT, true);          n2.setHorizontalAlignment(SwingConstants.CENTER);
        p2ScoreLabel = lbl("0 pts", 22, RED_LIGHT, true);      p2ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        p2FinalLabel = lbl("Final: 0", 11, TEXT_MUTED, false); p2FinalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(l2); p2.add(n2); p2.add(p2ScoreLabel); p2.add(p2FinalLabel);

        p.add(p1); p.add(mid); p.add(p2);
        return p;
    }

    JPanel buildBattlePanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBackground(BG_DARK);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.weighty = 1.0;
        gc.insets = new Insets(0, 4, 0, 4);

        gc.gridx = 0; gc.weightx = 0.42;
        p1FieldPanel = new JPanel(new BorderLayout());
        p1FieldPanel.setBackground(BG_DARK);
        JLabel zl1 = lbl("YOUR FIELD", 10, CYAN, false); zl1.setHorizontalAlignment(SwingConstants.CENTER);
        p1FieldPanel.add(zl1, BorderLayout.NORTH);
        p1FieldWidget = new CardWidget(null);
        p1FieldPanel.add(p1FieldWidget, BorderLayout.CENTER);
        p.add(p1FieldPanel, gc);

        gc.gridx = 1; gc.weightx = 0.16;
        midPanel = new JPanel();
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        midPanel.setBackground(BG_DARK);
        vsBanner = lbl("VS", 36, GOLD, true); vsBanner.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel = lbl("", 13, GOLD, true); resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        midPanel.add(Box.createVerticalGlue());
        midPanel.add(vsBanner);
        midPanel.add(Box.createVerticalStrut(8));
        midPanel.add(resultLabel);
        midPanel.add(Box.createVerticalGlue());
        p.add(midPanel, gc);

        gc.gridx = 2; gc.weightx = 0.42;
        p2FieldPanel = new JPanel(new BorderLayout());
        p2FieldPanel.setBackground(BG_DARK);
        JLabel zl2 = lbl("CPU FIELD", 10, RED_LIGHT, false); zl2.setHorizontalAlignment(SwingConstants.CENTER);
        p2FieldPanel.add(zl2, BorderLayout.NORTH);
        p2FieldWidget = new CardWidget(null);
        p2FieldPanel.add(p2FieldWidget, BorderLayout.CENTER);
        p.add(p2FieldPanel, gc);

        return p;
    }

    JPanel buildLogPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(new Color(15,15,20));
        p.setBorder(BorderFactory.createLineBorder(BORDER_DIM));
        logPane = new JTextPane();
        logPane.setEditable(false);
        logPane.setBackground(new Color(15,15,20));
        logPane.setForeground(TEXT_MUTED);
        logPane.setFont(fontMono);
        logPane.setMargin(new Insets(6,10,6,10));
        JScrollPane sp = new JScrollPane(logPane);
        sp.setBorder(null);
        sp.setBackground(new Color(15,15,20));
        sp.getViewport().setBackground(new Color(15,15,20));
        p.add(sp, BorderLayout.CENTER);
        return p;
    }

    // ── Field Card Widget ─────────────────────────────────────────
    class CardWidget extends JPanel {
        Card card;
        boolean winner, loser;

        CardWidget(Card card) {
            this.card = card;
            setOpaque(false);
            setPreferredSize(new Dimension(160, 220));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int w = getWidth(), h = getHeight();
            RoundRectangle2D rr = new RoundRectangle2D.Float(1,1,w-2,h-2,16,16);
            if (card == null) {
                g2.setColor(new Color(20,20,36)); g2.fill(rr);
                g2.setColor(BORDER_DIM);
                g2.setStroke(new BasicStroke(1.5f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,0,new float[]{6,4},0));
                g2.draw(rr);
                g2.setColor(new Color(60,60,80));
                g2.setFont(new Font("Dialog", Font.PLAIN, 12));
                String txt = "Waiting...";
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(txt, (w-fm.stringWidth(txt))/2, h/2+fm.getAscent()/2);
            } else {
                drawCard(g2, w, h, rr, card, winner, loser, false);
            }
            g2.dispose();
        }
    }

    // ── Hand Card Widget ──────────────────────────────────────────
    class HandCardWidget extends JPanel {
        final Card card;
        boolean selected;

        HandCardWidget(Card c) {
            this.card = c;
            setPreferredSize(new Dimension(100, 90));
            setOpaque(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setBorder(BorderFactory.createLineBorder(BORDER_DIM, 1, true));

            // THE KEY FIX: mouse listener calls selectCard() on the outer class
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectCard(card);   // <-- delegates to outer class method
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!selected) setBorder(BorderFactory.createLineBorder(GOLD, 1, true));
                    repaint();
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (!selected) setBorder(BorderFactory.createLineBorder(BORDER_DIM, 1, true));
                    repaint();
                }
            });
        }

        void setSelected(boolean s) {
            selected = s;
            setBorder(BorderFactory.createLineBorder(s ? GOLD : BORDER_DIM, s ? 2 : 1, true));
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int w = getWidth(), h = getHeight();
            RoundRectangle2D rr = new RoundRectangle2D.Float(1,1,w-2,h-2,10,10);

            g2.setColor(selected ? new Color(42,42,26) : new Color(30,30,55));
            g2.fill(rr);
            if (selected) { g2.setColor(new Color(255,215,0,30)); g2.fill(rr); }

            g2.setFont(new Font("Dialog", Font.PLAIN, 22));
            g2.setColor(Color.WHITE);
            g2.drawString(card.emoji, 8, 30);

            g2.setFont(new Font("Dialog", Font.BOLD, 9));
            g2.setColor(Color.WHITE);
            String name = card.name.length() > 14 ? card.name.substring(0,13)+"…" : card.name;
            g2.drawString(name, 6, 48);

            g2.setFont(new Font("Dialog", Font.BOLD, 18));
            g2.setColor(GOLD);
            g2.drawString(String.valueOf(card.power), 8, 72);

            Color rc = switch(card.rarity) {
                case "legendary" -> GOLD; case "epic" -> PURPLE;
                case "rare" -> new Color(52,152,219); default -> new Color(80,80,80);
            };
            g2.setColor(rc);
            g2.fillOval(w-14, 6, 8, 8);
            g2.dispose();
        }
    }

    // ── Shared card paint ─────────────────────────────────────────
    void drawCard(Graphics2D g2, int w, int h, RoundRectangle2D rr,
                  Card card, boolean winner, boolean loser, boolean selected) {
        g2.setColor(BG_CARD); g2.fill(rr);
        Color ad = new Color(card.accent.getRed(), card.accent.getGreen(), card.accent.getBlue(), 40);
        g2.setColor(ad); g2.fill(new RoundRectangle2D.Float(w/2f, h/2f, w, h, 16, 16));
        if (winner)      { g2.setColor(new Color(0,255,136,20)); g2.fill(rr); }
        else if (loser)  { g2.setColor(new Color(255,50,50,20)); g2.fill(rr); }

        // Rarity badge
        Color rb = switch(card.rarity) {
            case "legendary" -> GOLD; case "epic" -> PURPLE;
            case "rare" -> new Color(52,152,219); default -> new Color(80,80,80);
        };
        Color rf = card.rarity.equals("legendary") ? Color.BLACK : Color.WHITE;
        g2.setFont(new Font("Dialog", Font.BOLD, 9));
        String rt = card.rarity.toUpperCase();
        FontMetrics rfm = g2.getFontMetrics();
        int rw = rfm.stringWidth(rt)+10, rh = 16;
        g2.setColor(rb); g2.fillRoundRect(w-rw-6, 6, rw, rh, 8, 8);
        g2.setColor(rf); g2.drawString(rt, w-rw-1, 6+rh-4);

        // Emoji
        g2.setFont(new Font("Dialog", Font.PLAIN, 40));
        g2.setColor(Color.WHITE);
        FontMetrics efm = g2.getFontMetrics();
        g2.drawString(card.emoji, (w-efm.stringWidth(card.emoji))/2, 72);

        // Name
        g2.setFont(new Font("Dialog", Font.BOLD, 13));
        FontMetrics nfm = g2.getFontMetrics();
        g2.setColor(Color.WHITE);
        if (nfm.stringWidth(card.name) > w-12) {
            String[] words = card.name.split(" ");
            StringBuilder line = new StringBuilder();
            int y = 94;
            for (String word : words) {
                if (nfm.stringWidth(line+word) > w-14) {
                    String s = line.toString().trim();
                    g2.drawString(s, (w-nfm.stringWidth(s))/2, y);
                    y += nfm.getHeight();
                    line = new StringBuilder(word+" ");
                } else { line.append(word).append(" "); }
            }
            String s = line.toString().trim();
            g2.drawString(s, (w-nfm.stringWidth(s))/2, y);
        } else { g2.drawString(card.name, (w-nfm.stringWidth(card.name))/2, 94); }

        // Category
        g2.setFont(new Font("Dialog", Font.PLAIN, 10));
        FontMetrics cfm = g2.getFontMetrics();
        g2.setColor(new Color(180,180,180));
        String cat = card.category.toUpperCase();
        g2.drawString(cat, (w-cfm.stringWidth(cat))/2, 114);

        // Power number + bar
        g2.setFont(new Font("Dialog", Font.BOLD, 11));
        g2.setColor(TEXT_MUTED); g2.drawString("POWER", 10, h-52);
        g2.setFont(new Font("Dialog", Font.BOLD, 22));
        g2.setColor(GOLD);
        String pw = String.valueOf(card.power);
        g2.drawString(pw, w-g2.getFontMetrics().stringWidth(pw)-10, h-38);
        int bx=10, by=h-34, bw=w-20, bh=8;
        g2.setColor(new Color(40,40,60)); g2.fillRoundRect(bx,by,bw,bh,4,4);
        Color bc = card.power>=85 ? GOLD : card.power>=70 ? PURPLE : new Color(52,152,219);
        g2.setColor(bc); g2.fillRoundRect(bx,by,(int)(bw*card.power/100.0),bh,4,4);

        if (selected) { g2.setColor(new Color(255,215,0,60)); g2.fill(rr); }
    }

    // ── THE FIX: single authoritative selectCard method ───────────
    void selectCard(Card c) {
        if (phase != Phase.PLAY && phase != Phase.TAG) return;
        // Toggle: clicking the same card deselects it
        p1Selected = (p1Selected != null && p1Selected.id == c.id) ? null : c;
        // Update button immediately — this was the root cause of the bug
        playBtn.setEnabled(p1Selected != null);
        playBtn.setText(phase == Phase.TAG ? "ADD TAG CARD!" : "PLAY CARD!");
        refreshHandUI();
    }

    // ── Game Logic ────────────────────────────────────────────────
    void startGame() {
        // Deduplicate by id first
        Map<Integer, Card> seen = new LinkedHashMap<>();
        for (Card c : ALL_CARDS) seen.putIfAbsent(c.id, c);
        List<Card> deck = new ArrayList<>(seen.values());
        Collections.shuffle(deck);

        int half = Math.min(16, deck.size() / 2);
        p1Hand = new ArrayList<>(deck.subList(0, half));
        p2Hand = new ArrayList<>(deck.subList(half, half * 2));

        p1Score = p2Score = p1Power = p2Power = round = tagTurn = 0;
        p1Field = p2Field = p1Selected = null;
        p1TagCards.clear(); p2TagCards.clear();
        logLines.clear();
        result = Result.NONE;
        phase  = Phase.PLAY;
        addLog("Game started! " + maxRounds + " rounds of pop culture mayhem!", "info");
        refreshUI();
    }

    Card cpuChoose(List<Card> hand, List<Card> avoid) {
        return hand.stream()
            .filter(c -> avoid.stream().noneMatch(a -> a.id == c.id))
            .max(Comparator.comparingInt(c -> c.power))
            .orElse(hand.get(0));
    }

    void onPlayCard() {
        if (p1Selected == null) return;
        if (phase == Phase.PLAY) doPlayRound();
        else if (phase == Phase.TAG) doTagRound();
    }

    void doPlayRound() {
        Card p1c = p1Selected;
        Card p2c = cpuChoose(p2Hand, List.of());
        p1Hand.remove(p1c); p2Hand.remove(p2c);
        p1Field = p1c; p2Field = p2c;
        round++; p1Selected = null;

        if (p1c.power == p2c.power) {
            phase = Phase.TAG;
            p1TagCards = new ArrayList<>(List.of(p1c));
            p2TagCards = new ArrayList<>(List.of(p2c));
            tagTurn = 0; result = Result.TIE;
            addLog("⚡ TIE! " + p1c.name + " vs " + p2c.name + " — Both " + p1c.power + " power! TAG MATCH!", "tag");
        } else if (p1c.power > p2c.power) {
            p1Score += 2; p1Power += p1c.power; p2Power += p2c.power;
            result = Result.P1_WIN;
            addLog("✅ YOU WIN! " + p1c.name + " (" + p1c.power + ") beats " + p2c.name + " (" + p2c.power + ")  +2pts", "win");
            checkEnd();
        } else {
            p2Score += 2; p1Power += p1c.power; p2Power += p2c.power;
            result = Result.P2_WIN;
            addLog("❌ CPU WINS! " + p2c.name + " (" + p2c.power + ") beats " + p1c.name + " (" + p1c.power + ")  +2pts", "lose");
            checkEnd();
        }
        refreshUI();
    }

    void doTagRound() {
        Card p1t = p1Selected;
        Card p2t = cpuChoose(p2Hand, p2TagCards);
        p1Hand.remove(p1t); p2Hand.remove(p2t);
        p1TagCards.add(p1t); p2TagCards.add(p2t);
        p1Selected = null; tagTurn++;

        int p1Tot = p1TagCards.stream().mapToInt(c -> c.power).sum();
        int p2Tot = p2TagCards.stream().mapToInt(c -> c.power).sum();
        addLog("Tag added: " + p1t.name + " (" + p1t.power + ") vs " + p2t.name + " (" + p2t.power + ")", "tag");

        if (tagTurn >= 2 || p1Tot != p2Tot) resolveTag(p1Tot, p2Tot);
        else addLog("Still tied! Another tag card needed...", "info");
        refreshUI();
    }

    void resolveTag(int p1Tot, int p2Tot) {
        p1Power += p1Tot; p2Power += p2Tot;
        if (p1Tot > p2Tot) {
            p1Score += 5; result = Result.P1_TAG;
            addLog("🏆 TAG WIN! YOU win " + p1Tot + " vs " + p2Tot + "! +5pts MEGA BONUS!", "win");
        } else if (p2Tot > p1Tot) {
            p2Score += 5; result = Result.P2_TAG;
            addLog("💀 CPU TAG WIN! " + p2Tot + " vs " + p1Tot + "! +5pts for CPU!", "lose");
        } else {
            result = Result.DRAW_TAG;
            addLog("🤯 ABSOLUTE TIE even in tag! No points!", "info");
        }
        phase = Phase.PLAY; tagTurn = 0;
        checkEnd();
    }

    void checkEnd() {
        if (round >= maxRounds || p1Hand.isEmpty() || p2Hand.isEmpty())
            phase = Phase.GAMEOVER;
    }

    void addLog(String msg, String type) {
        logLines.add(0, new String[]{msg, type});
        if (logLines.size() > 30) logLines.remove(logLines.size()-1);
    }

    // ── UI Refresh ────────────────────────────────────────────────
    void refreshUI() {
        p1ScoreLabel.setText(p1Score + " pts  +" + p1Power + " pw");
        p2ScoreLabel.setText(p2Score + " pts  +" + p2Power + " pw");
        p1FinalLabel.setText("Final: " + (p1Score + p1Power));
        p2FinalLabel.setText("Final: " + (p2Score + p2Power));
        roundLabel.setText(round + " / " + maxRounds);

        tagBanner.setVisible(phase == Phase.TAG);
        playBtn.setText(phase == Phase.TAG ? "ADD TAG CARD!" : "PLAY CARD!");
        playBtn.setEnabled(p1Selected != null && (phase == Phase.PLAY || phase == Phase.TAG));

        p1FieldWidget.card   = p1Field;
        p2FieldWidget.card   = p2Field;
        p1FieldWidget.winner = result == Result.P1_WIN || result == Result.P1_TAG;
        p1FieldWidget.loser  = result == Result.P2_WIN || result == Result.P2_TAG;
        p2FieldWidget.winner = result == Result.P2_WIN || result == Result.P2_TAG;
        p2FieldWidget.loser  = result == Result.P1_WIN || result == Result.P1_TAG;
        p1FieldWidget.repaint();
        p2FieldWidget.repaint();

        if (phase == Phase.TAG) {
            int p1Tot = p1TagCards.stream().mapToInt(c -> c.power).sum();
            int p2Tot = p2TagCards.stream().mapToInt(c -> c.power).sum();
            resultLabel.setText("YOU: " + p1Tot + "   CPU: " + p2Tot);
            resultLabel.setForeground(PURPLE);
        } else {
            switch(result) {
                case P1_WIN   -> { resultLabel.setText("YOU WIN +2");  resultLabel.setForeground(CYAN); }
                case P2_WIN   -> { resultLabel.setText("CPU WINS +2"); resultLabel.setForeground(RED_LIGHT); }
                case P1_TAG   -> { resultLabel.setText("TAG WIN +5!"); resultLabel.setForeground(GREEN_WIN); }
                case P2_TAG   -> { resultLabel.setText("CPU TAG +5!"); resultLabel.setForeground(RED_LIGHT); }
                case DRAW_TAG -> { resultLabel.setText("DRAW!");       resultLabel.setForeground(GOLD); }
                default       -> resultLabel.setText("");
            }
        }

        refreshLog();
        refreshHandUI();
        revalidate(); repaint();

        if (phase == Phase.GAMEOVER)
            SwingUtilities.invokeLater(this::showGameOver);
    }

    void refreshHandUI() {
        handGrid.removeAll();
        for (Card c : p1Hand) {
            HandCardWidget hw = new HandCardWidget(c);
            if (p1Selected != null && p1Selected.id == c.id) hw.setSelected(true);
            handGrid.add(hw);
        }
        handGrid.revalidate();
        handGrid.repaint();
    }

    void refreshLog() {
        StringBuilder sb = new StringBuilder();
        for (String[] e : logLines) sb.append(e[0]).append("\n");
        logPane.setText(sb.toString());
        logPane.setCaretPosition(0);
    }

    // ── Dialogs ───────────────────────────────────────────────────
    void showStartScreen() {
        JDialog dlg = new JDialog(this, "Welcome to CyberClash!", true);
        dlg.setSize(420, 320); dlg.setLocationRelativeTo(this); dlg.setResizable(false);

        JPanel p = new JPanel(); p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_DARK); p.setBorder(BorderFactory.createEmptyBorder(24,28,24,28));

        JLabel t1 = lbl("⚡ MemeClash! ⚡", 28, GOLD, true); t1.setAlignmentX(CENTER_ALIGNMENT);
        JLabel t2 = lbl("Pop Culture Card's Ultimate Battle", 13, TEXT_MUTED, false); t2.setAlignmentX(CENTER_ALIGNMENT);

        JTextArea desc = new JTextArea(
            "Each player gets a random deck of 16 cards.\n" +
            "Play 20 rounds — higher power card WINS +2 pts.\n" +
            "If powers TIE → TAG MATCH begins! Add partner\n" +
            "cards, most combined power wins +5 pts!\n\n" +
            "Final score = Round Points + All Card Power Used."
        );
        desc.setFont(new Font("Dialog", Font.PLAIN, 12));
        desc.setForeground(new Color(180,180,200)); desc.setBackground(BG_DARK);
        desc.setEditable(false); desc.setLineWrap(true); desc.setWrapStyleWord(true);
        desc.setAlignmentX(CENTER_ALIGNMENT);

        JButton startBtn = makeButton("LET'S GET IT!", GOLD, Color.BLACK);
        startBtn.setAlignmentX(CENTER_ALIGNMENT); startBtn.setMaximumSize(new Dimension(200, 44));
        startBtn.addActionListener(e -> { dlg.dispose(); startGame(); });

        p.add(t1); p.add(Box.createVerticalStrut(4));
        p.add(t2); p.add(Box.createVerticalStrut(16));
        p.add(desc); p.add(Box.createVerticalStrut(20));
        p.add(startBtn);
        dlg.setContentPane(p); dlg.setVisible(true);
    }

    void showGameOver() {
        int p1Final = p1Score + p1Power, p2Final = p2Score + p2Power;
        String winner = p1Final > p2Final ? "GOT THE W! 🏆" : p1Final < p2Final ? "YOU'RE COOKED! 💀" : "DRAW! N I C E 🤝";
        Color  wColor = p1Final > p2Final ? CYAN : p1Final < p2Final ? RED_LIGHT : GOLD;

        JDialog dlg = new JDialog(this, "Game Over!", true);
        dlg.setSize(400, 340); dlg.setLocationRelativeTo(this); dlg.setResizable(false);

        JPanel p = new JPanel(); p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_DARK); p.setBorder(BorderFactory.createEmptyBorder(24,28,24,28));

        JLabel wl = lbl(winner, 30, wColor, true); wl.setAlignmentX(CENTER_ALIGNMENT);
        JLabel sl = lbl("Final Score = Round Points + Card Power", 11, TEXT_MUTED, false); sl.setAlignmentX(CENTER_ALIGNMENT);

        JPanel grid = new JPanel(new GridLayout(1,2,12,0));
        grid.setBackground(BG_DARK); grid.setMaximumSize(new Dimension(340,100));
        grid.add(scoreCard("YOU", p1Final, p1Score, p1Power, CYAN));
        grid.add(scoreCard("CPU", p2Final, p2Score, p2Power, RED_LIGHT));

        JButton again = makeButton("PLAY AGAIN!", GOLD, Color.BLACK);
        again.setAlignmentX(CENTER_ALIGNMENT); again.setMaximumSize(new Dimension(200,44));
        again.addActionListener(e -> { dlg.dispose(); startGame(); });

        p.add(wl); p.add(Box.createVerticalStrut(4));
        p.add(sl); p.add(Box.createVerticalStrut(16));
        p.add(grid); p.add(Box.createVerticalStrut(20));
        p.add(again);
        dlg.setContentPane(p); dlg.setVisible(true);
    }

    JPanel scoreCard(String name, int fin, int pts, int pw, Color col) {
        JPanel p = new JPanel(); p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(26,26,46));
        p.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(col.getRed(),col.getGreen(),col.getBlue(),80),2,true),
            BorderFactory.createEmptyBorder(10,14,10,14)));
        JLabel nl = lbl(name, 13, col, false);          nl.setAlignmentX(CENTER_ALIGNMENT);
        JLabel fl = lbl(String.valueOf(fin), 28, col, true); fl.setAlignmentX(CENTER_ALIGNMENT);
        JLabel dl = lbl(pts+"pts + "+pw+" pw", 11, TEXT_MUTED, false); dl.setAlignmentX(CENTER_ALIGNMENT);
        p.add(nl); p.add(fl); p.add(dl);
        return p;
    }

    // ── Helpers ───────────────────────────────────────────────────
    JLabel lbl(String text, int size, Color color, boolean bold) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Dialog", bold ? Font.BOLD : Font.PLAIN, size));
        l.setForeground(color);
        return l;
    }

    JButton makeButton(String text, Color bg, Color fg) {
        JButton b = new JButton(text) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(isEnabled() ? bg : new Color(60,60,70));
                g2.fillRoundRect(0,0,getWidth(),getHeight(),10,10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        b.setFont(new Font("Dialog", Font.BOLD, 15));
        b.setForeground(fg);
        b.setBorderPainted(false); b.setFocusPainted(false);
        b.setContentAreaFilled(false); b.setOpaque(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.setPreferredSize(new Dimension(160, 40));
        return b;
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(MemeClash::new);
    }
}