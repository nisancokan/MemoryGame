package MemoryGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class SaveGame implements Serializable {
        public static void gameSave (Card [][] cards) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("kayıt.bin"))) {
                System.out.println("Saving game...");

                out.writeObject(cards);
            } catch (IOException ex) {
                Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public static Card [][] takeSave () {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("kayıt.bin"))) {
                Card [][] array = (Card [][])in.readObject();

                return array;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SaveGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

