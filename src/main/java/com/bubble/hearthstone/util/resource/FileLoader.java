// package com.bubble.hearthstone.util.resource;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.io.Reader;
// import java.util.LinkedList;
// import java.util.List;

// import com.bubble.hearthstone.util.services.ServiceLocator;


// public class FileLoader extends ResourceLoader<String> {

//     private final String filename;
    
//     public FileLoader(String filename) {
//         super(null);
//         this.filename = filename;
//     }

//     @Override
//     protected String getKey() { return null; }

//     @Override
//     protected String getPath() {
//         return filename;
//     }


//     @Override
//     protected String loadResource(String path) {
//         final BufferedReader br = new BufferedReader(getReader());
//         final List<String> list = new LinkedList<>();
//         String line;
//         try {
//             while ((line = br.readLine()) != null) {
//                 list.add(line);
//             }
//         } catch (IOException e) {
//             ServiceLocator.getLogger().error(this, e);
//         }
//         return list;
//     }

//     private Reader getReader(String path) {      
//         try {
//                 return new FileReader(path);
//         } catch (FileNotFoundException e) {
//             ServiceLocator.getLogger().error(this, e);
//             return null;
//         }
//     }
// }
    