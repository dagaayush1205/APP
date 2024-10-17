import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class LibraryManagementSystem {

    // Data structure to store book information
    private ArrayList<Book> books = new ArrayList<>();

    // GUI components
    private JFrame frame;
    private JTable bookTable;
    private JTextField searchField;
    private JTextField titleField, authorField, isbnField, yearField;
    private JComboBox<String> genreBox;
    private JCheckBox availabilityCheck;
    
    public LibraryManagementSystem() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);
        
        // Tool bar with buttons
        JToolBar toolBar = new JToolBar();
        JButton addBookButton = new JButton("Add Book");
        JButton removeBookButton = new JButton("Remove Book");
        JButton searchBookButton = new JButton("Search");
        toolBar.add(addBookButton);
        toolBar.add(removeBookButton);
        toolBar.add(searchBookButton);
        frame.add(toolBar, BorderLayout.NORTH);
        
        // Tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Book Details Panel
        JPanel bookDetailsPanel = new JPanel(new GridLayout(6, 2));
        titleField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();
        yearField = new JTextField();
        genreBox = new JComboBox<>(new String[] { "Fiction", "Non-fiction", "Sci-Fi", "Romance" });
        availabilityCheck = new JCheckBox("Available");

        bookDetailsPanel.add(new JLabel("Title:"));
        bookDetailsPanel.add(titleField);
        bookDetailsPanel.add(new JLabel("Author:"));
        bookDetailsPanel.add(authorField);
        bookDetailsPanel.add(new JLabel("ISBN:"));
        bookDetailsPanel.add(isbnField);
        bookDetailsPanel.add(new JLabel("Year:"));
        bookDetailsPanel.add(yearField);
        bookDetailsPanel.add(new JLabel("Genre:"));
        bookDetailsPanel.add(genreBox);
        bookDetailsPanel.add(availabilityCheck);

        JPanel bookButtonsPanel = new JPanel();
        JButton addBook = new JButton("Add Book");
        JButton updateBook = new JButton("Update Book");
        bookButtonsPanel.add(addBook);
        bookButtonsPanel.add(updateBook);
        bookDetailsPanel.add(bookButtonsPanel);

        tabbedPane.addTab("Book Details", bookDetailsPanel);
        
        // Book List Panel
        JPanel bookListPanel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);
        bookListPanel.add(searchPanel, BorderLayout.NORTH);

        String[] columns = { "Title", "Author", "ISBN", "Genre", "Available" };
        Object[][] data = {};  // Initially empty
        bookTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        bookListPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Book List", bookListPanel);
        
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // Event handling
        addBook.addActionListener(e -> addNewBook());
    }

    // Function to add a new book to the list
    private void addNewBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String isbn = isbnField.getText();
        String year = yearField.getText();
        String genre = (String) genreBox.getSelectedItem();
        boolean isAvailable = availabilityCheck.isSelected();

        Book newBook = new Book(title, author, isbn, year, genre, isAvailable);
        books.add(newBook);
        
        // Refresh table (simplified)
        refreshBookTable();
    }

    // Function to refresh the book table (simplified for this example)
    private void refreshBookTable() {
        String[] columns = { "Title", "Author", "ISBN", "Genre", "Available" };
        Object[][] data = new Object[books.size()][5];

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            data[i][0] = book.getTitle();
            data[i][1] = book.getAuthor();
            data[i][2] = book.getIsbn();
            data[i][3] = book.getGenre();
            data[i][4] = book.isAvailable();
        }

        bookTable.setModel(new javax.swing.table.DefaultTableModel(data, columns));
    }

    public static void main(String[] args) {
        new LibraryManagementSystem();
    }

    // Book class (for storing book details)
    class Book {
        private String title, author, isbn, year, genre;
        private boolean available;

        public Book(String title, String author, String isbn, String year, String genre, boolean available) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.year = year;
            this.genre = genre;
            this.available = available;
        }

        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }
        public String getYear() { return year; }
        public String getGenre() { return genre; }
        public boolean isAvailable() { return available; }
    }
}

