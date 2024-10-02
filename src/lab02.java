import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class lab02 {
    // Объявление графических компонентов
    private JFrame mainFrame;
    private DefaultTableModel tableModel;
    private JTable dataTable;
    private JButton addDogButton, editDogButton, deleteDogButton;
    private JTextField searchField;
    private JComboBox<String> breedComboBox;

    public void show() {
        // Создание основного окна
        mainFrame = new JFrame("Dog Show Administration");
        mainFrame.setSize(800, 400);
        mainFrame.setLocation(100, 100);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание кнопок
        addDogButton = new JButton("Добавить собаку");
        editDogButton = new JButton("Изменить данные собаки");
        deleteDogButton = new JButton("Удалить собаку");

        // Панель инструментов с кнопками
        JToolBar toolBar = new JToolBar("Панель инструментов");
        toolBar.add(addDogButton);
        toolBar.add(editDogButton);
        toolBar.add(deleteDogButton);

        // Добавление панели инструментов в верхнюю часть окна
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(toolBar, BorderLayout.NORTH);

        // Создание таблицы с данными о собаках
        String[] columns = {"Кличка", "Порода", "Владелец", "Судья"};
        String[][] data = {
                {"Рекс", "Немецкая овчарка", "Иванов И.И.", "Петров П.П."},
                {"Барон", "Доберман", "Петров П.П.", "Сидоров С.С."}
        };
        tableModel = new DefaultTableModel(data, columns);
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Добавление таблицы в центральную часть окна
        mainFrame.add(scrollPane, BorderLayout.CENTER);

        // Элементы фильтрации и поиска
        breedComboBox = new JComboBox<>(new String[]{"Все породы", "Немецкая овчарка", "Доберман"});
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Поиск");

        // Панель фильтрации
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Фильтр по породе:"));
        searchPanel.add(breedComboBox);
        searchPanel.add(new JLabel("Поиск по владельцу:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Размещение панели фильтрации в нижней части окна
        mainFrame.add(searchPanel, BorderLayout.SOUTH);

        // Визуализация окна
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Создание и отображение формы
        new lab02().show();
    }
}
