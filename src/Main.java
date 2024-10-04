import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Лебедев Игнат 3312
 * @version 1.0
 */
public class Main {
    // Объявление графических компонентов
    private JFrame mainFrame;
    private DefaultTableModel tableModel;
    private JTable dataTable;
    private JButton addDogButton, editDogButton, deleteDogButton, loadDogButton, saveDogButton;
    private JTextField searchField;
    private JComboBox<String> breedComboBox;

    /**
     * Метод для построения и визуализации экранной формы.
     */
    public void show() {
        // Создание основного окна
        mainFrame = new JFrame("Dog Show Administration");
        mainFrame.setSize(800, 400);
        mainFrame.setLocation(100, 100);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание кнопок для панели инструментов
        addDogButton = new JButton("Добавить");
        editDogButton = new JButton("Изменить");
        deleteDogButton = new JButton("Удалить");
        loadDogButton = new JButton("Загрузить");
        saveDogButton = new JButton("Сохранить");

        // Создание панели инструментов и добавление кнопок
        JToolBar toolBar = new JToolBar("Панель инструментов");
        toolBar.add(addDogButton);
        toolBar.add(editDogButton);
        toolBar.add(deleteDogButton);
        toolBar.add(loadDogButton);
        toolBar.add(saveDogButton);

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

        // Создание элементов фильтрации и поиска
        breedComboBox = new JComboBox<>(new String[]{"Все породы", "Немецкая овчарка", "Доберман"});
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Поиск");

        // Создание панели поиска и фильтрации
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Фильтр по породе:"));
        searchPanel.add(breedComboBox);
        searchPanel.add(new JLabel("Поиск по владельцу:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Добавление панели поиска в нижнюю часть окна
        mainFrame.add(searchPanel, BorderLayout.SOUTH);

        // Отображение окна
        mainFrame.setVisible(true);
    }

    /**
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание и отображение формы
        new Main().show();
    }
}
