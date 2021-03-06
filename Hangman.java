import java.util.*;
public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bodyParts = 0;
        int score = 0; //How many right letters guessed
        char[] lettersGuessed = new char[26]; //Array of guessed letters
        String word = getMysteryWord();
        char[] blanks = setUpGameBoard(word);
        boolean gameExit = false; //If true, exit game loop
        while (gameExit == false) { //Main loop
            for (int i = 50; i >= 0; i--) //Print 50 lines instead of clearing console
                System.out.println("");
            String endGame = isEndGame(word, blanks, score, bodyParts); //Test if the game ended
            //What to do if game ended
            if (endGame.equals("win")) {
                endGame(true, word, blanks);
                gameExit = true;
            } else if (endGame.equals("lose")) {
                endGame(false, word, blanks);
                gameExit = true;
            }
            //Display Game Components
            displayLettersGuessed(lettersGuessed);
            displayGallows(bodyParts);
            displayGameBoard(blanks, lettersGuessed);

            if (gameExit == true) {
                input.close();
                break;
            }
            //handle user input
            System.out.print("Guess a letter: ");
            char guessChar = input.nextLine().charAt(0);
            int num = checkGuess(guessChar, word, blanks, lettersGuessed);
            //handle scoring
            if (num == 0)
                bodyParts++;
            else if (num > 0)
                score += num;
        }
    }
    //returns random word from wordBank
    public static String getMysteryWord() {
        String[] wordBank = {"the","of","to","and","a","in","is","it","you","that","he","was","for","on","are","with","as","I","his","they","be","at","one","have","this","from","or","had","by","hot","word","but","what","some","we","can","out","other","were","all","there","when","up","use","your","how","said","an","each","she","which","do","their","time","if","will","way","about","many","then","them","write","would","like","so","these","her","long","make","thing","see","him","two","has","look","more","day","could","go","come","did","number","sound","no","most","people","my","over","know","water","than","call","first","who","may","down","side","been","now","find","any","new","work","part","take","get","place","made","live","where","after","back","little","only","round","man","year","came","show","every","good","me","give","our","under","name","very","through","just","form","sentence","great","think","say","help","low","line","differ","turn","cause","much","mean","before","move","right","boy","old","too","same","tell","does","set","three","want","air","well","also","play","small","end","put","home","read","hand","port","large","spell","add","even","land","here","must","big","high","such","follow","act","why","ask","men","change","went","light","kind","off","need","house","picture","try","us","again","animal","point","mother","world","near","build","self","earth","father","head","stand","own","page","should","country","found","answer","school","grow","study","still","learn","plant","cover","food","sun","four","between","state","keep","eye","never","last","let","thought","city","tree","cross","farm","hard","start","might","story","saw","far","sea","draw","left","late","run","don't","while","press","close","night","real","life","few","north","open","seem","together","next","white","children","begin","got","walk","example","ease","paper","group","always","music","those","both","mark","often","letter","until","mile","river","car","feet","care","second","book","carry","took","science","eat","room","friend","began","idea","fish","mountain","stop","once","base","hear","horse","cut","sure","watch","color","face","wood","main","enough","plain","girl","usual","young","ready","above","ever","red","list","though","feel","talk","bird","soon","body","dog","family","direct","pose","leave","song","measure","door","product","black","short","numeral","class","wind","question","happen","complete","ship","area","half","rock","order","fire","south","problem","piece","told","knew","pass","since","top","whole","king","space","heard","best","hour","better","true","during","hundred","five","remember","step","early","hold","west","ground","interest","reach","fast","verb","sing","listen","six","table","travel","less","morning","ten","simple","several","vowel","toward","war","lay","against","pattern","slow","center","love","person","money","serve","appear","road","map","rain","rule","govern","pull","cold","notice","voice","unit","power","town","fine","certain","fly","fall","lead","cry","dark","machine","note","wait","plan","figure","star","box","noun","field","rest","correct","able","pound","done","beauty","drive","stood","contain","front","teach","week","final","gave","green","oh","quick","develop","ocean","warm","free","minute","strong","special","mind","behind","clear","tail","produce","fact","street","inch","multiply","nothing","course","stay","wheel","full","force","blue","object","decide","surface","deep","moon","island","foot","system","busy","test","record","boat","common","gold","possible","plane","stead","dry","wonder","laugh","thousand","ago","ran","check","game","shape","equate","hot","miss","brought","heat","snow","tire","bring","yes","distant","fill","east","paint","language","among","grand","ball","yet","wave","drop","heart","am","present","heavy","dance","engine","position","arm","wide","sail","material","size","vary","settle","speak","weight","general","ice","matter","circle","pair","include","divide","syllable","felt","perhaps","pick","sudden","count","square","reason","length","represent","art","subject","region","energy","hunt","probable","bed","brother","egg","ride","cell","believe","fraction","forest","sit","race","window","store","summer","train","sleep","prove","lone","leg","exercise","wall","catch","mount","wish","sky","board","joy","winter","sat","written","wild","instrument","kept","glass","grass","cow","job","edge","sign","visit","past","soft","fun","bright","gas","weather","month","million","bear","finish","happy","hope","flower","clothe","strange","gone","jump","baby","eight","village","meet","root","buy","raise","solve","metal","whether","push","seven","paragraph","third","shall","held","hair","describe","cook","floor","either","result","burn","hill","safe","cat","century","consider","type","law","bit","coast","copy","phrase","silent","tall","sand","soil","roll","temperature","finger","industry","value","fight","lie","beat","excite","natural","view","sense","ear","else","quite","broke","case","middle","kill","son","lake","moment","scale","loud","spring","observe","child","straight","consonant","nation","dictionary","milk","speed","method","organ","pay","age","section","dress","cloud","surprise","quiet","stone","tiny","climb","cool","design","poor","lot","experiment","bottom","key","iron","single","stick","flat","twenty","skin","smile","crease","hole","trade","melody","trip","office","receive","row","mouth","exact","symbol","die","least","trouble","shout","except","wrote","seed","tone","join","suggest","clean","break","lady","yard","rise","bad","blow","oil","blood","touch","grew","cent","mix","team","wire","cost","lost","brown","wear","garden","equal","sent","choose","fell","fit","flow","fair","bank","collect","save","control","decimal","gentle","woman","captain","practice","separate","difficult","doctor","please","protect","noon","whose","locate","ring","character","insect","caught","period","indicate","radio","spoke","atom","human","history","effect","electric","expect","crop","modern","element","hit","student","corner","party","supply","bone","rail","imagine","provide","agree","thus","capital","won't","chair","danger","fruit","rich","thick","soldier","process","operate","guess","necessary","sharp","wing","create","neighbor","wash","bat","rather","crowd","corn","compare","poem","string","bell","depend","meat","rub","tube","famous","dollar","stream","fear","sight","thin","triangle","planet","hurry","chief","colony","clock","mine","tie","enter","major","fresh","search","send","yellow","gun","allow","print","dead","spot","desert","suit","current","lift","rose","continue","block","chart","hat","sell","success","company","subtract","event","particular","deal","swim","term","opposite","wife","shoe","shoulder","spread","arrange","camp","invent","cotton","born","determine","quart","nine","truck","noise","level","chance","gather","shop","stretch","throw","shine","property","column","molecule","select","wrong","gray","repeat","require","broad","prepare","salt","nose","plural","anger","claim","continent","oxygen","sugar","death","pretty","skill","women","season","solution","magnet","silver","thank","branch","match","suffix","especially","fig","afraid","huge","sister","steel","discuss","forward","similar","guide","experience","score","apple","bought","led","pitch","coat","mass","card","band","rope","slip","win","dream","evening","condition","feed","tool","total","basic","smell","valley","nor","double","seat","arrive","master","track","parent","shore","division","sheet","substance","favor","connect","post","spend","chord","fat","glad","original","share","station","dad","bread","charge","proper","bar","offer","segment","slave","duck","instant","market","degree","populate","chick","dear","enemy","reply","drink","occur","support","speech","nature","range","steam","motion","path","liquid","log","meant","quotient","teeth","shell","neck",};
        return wordBank[(int)(Math.random() * wordBank.length)];
    }
    //Creates blanks array for the word
    public static char[] setUpGameBoard(String w) {
        char[] blanks = new char[w.length()];
        for (int i = 0; i < w.length(); i++)
            blanks[i] = '_';
        return blanks;
    }
    //Displays letters already guessed by user
    public static void displayLettersGuessed(char[] lettersGuessed) {
        System.out.print("Letters Guessed: ");
        for (int i = 0; i < lettersGuessed.length; i++)
            if (lettersGuessed[i] != 0) {
                if (i == 0)
                    System.out.print(lettersGuessed[i]);
                else
                    System.out.print("," + lettersGuessed[i]);
            }
        System.out.println("");
    }
    //Displays blanks array 
    public static void displayGameBoard(char[] b, char[] lettersGuessed) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("");
    }
    //Checks guess and returns how many times it appears in word, returns -1 if letter already guessed
    public static int checkGuess(char g, String w, char[] blanks, char[] lettersGuessed) {
        int n = 0;
        for (int i = 0; i < lettersGuessed.length; i++) {
            if (g == lettersGuessed[i])
                return -1;
        }
        int numLettersGuessed = 0;
        for (int i = 0; i < lettersGuessed.length; i++) {
            if (lettersGuessed[i] != 0)
                numLettersGuessed++;
        }
        lettersGuessed[numLettersGuessed] = g;
        for (int i = 0; i < w.length(); i++) {
            if (g == w.charAt(i) && blanks[i] != g) {
                n++;
                blanks[i] = g;
            }
        }
        return n;
    }
    //Returns "win", "lose", or "" to test if game has ended
    public static String isEndGame(String w, char[] b, int s, int body) {
        if (s == w.length())
            return "win";
        if (body == 6)
            return "lose";
        return "";
    }
    //Ends the game
    public static void endGame(boolean win, String w, char[] b) {
        if (win == false) {
            System.out.println("You Lose!");
            for (int i = 0; i < w.length(); i++)
                b[i] = w.charAt(i);
        } else
            System.out.println("You Win!");
    }
    //Displays the body of the game
    public static void displayGallows(int body) {
        System.out.println("   #######");
        System.out.println("   #     #");
        if (body >= 1)
            System.out.println("   #     O");
        else
            System.out.println("   #      ");
        if (body >= 2 && body <= 4)
            System.out.println("   #     |");
        else if (body == 5)
            System.out.println("   #    /|  ");
        else if (body == 6)
            System.out.println("   #    /|\\");
        else
            System.out.println("   #        ");
        if (body == 3)
            System.out.println("   #    /   ");
        else if (body >= 4)
            System.out.println("   #    / \\");
        else
            System.out.println("   #        ");
        System.out.println("   #");
        System.out.println(" #####");
    }
}
