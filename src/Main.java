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
    private JComboBox<String> searchCriteriaComboBox;

    /**
     * Метод для построения и визуализации экранной формы.
     */
    public void show() {
        // Создание основного окна
        mainFrame = new JFrame("Dog Show Administration");
        mainFrame.setSize(800, 400);
        mainFrame.setLocation(100, 100);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание основного контейнера с BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

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

        // Добавление панели инструментов в верхнюю часть mainPanel
        mainPanel.add(toolBar, BorderLayout.NORTH);

        // Создание таблицы с данными о собаках
        String[] columns = {"Кличка", "Порода", "Владелец", "Судья", "Награды"};
        String[][] data = {
                {"Рекс", "Немецкая овчарка", "Иванов И.И.", "Петров П.П.", "Лучший в породе"},
                {"Барон", "Доберман", "Петров П.П.", "Сидоров С.С.", "Нет наград"},
                {"Лесси", "Колли", "Смирнова А.А.", "Кузнецов К.К.", "Чемпион"},
                {"Бобик", "Бигль", "Ковалев В.В.", "Иванов И.И.", "Нет наград"}
        };
        tableModel = new DefaultTableModel(data, columns);
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Добавление таблицы в центральную часть mainPanel
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Создание элементов для простого поиска
        searchCriteriaComboBox = new JComboBox<>(new String[]{"По породе", "По владельцу", "По судье"});
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Поиск");

        // Создание панели поиска и фильтрации
        JPanel searchPanel = new JPanel();
        searchPanel.add(searchCriteriaComboBox);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Добавление панели поиска в нижнюю часть mainPanel
        mainPanel.add(searchPanel, BorderLayout.SOUTH);

        // Добавление mainPanel в главное окно
        mainFrame.add(mainPanel);

        // Отображение окна
        mainFrame.setVisible(true);
    }

    /**
     * Главный метод для запуска приложения.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание и отображение формы
        new Main().show();
    }
}
