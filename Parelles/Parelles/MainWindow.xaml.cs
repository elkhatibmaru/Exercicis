using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Parelles
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnPerSis_Click(object sender, RoutedEventArgs e)
        {
            Puzzle finestra = new Puzzle(6);
            finestra.ShowDialog();
        }

        private void btnPerQuatre_Click(object sender, RoutedEventArgs e)
        {

            Puzzle finestra = new Puzzle(4);
            finestra.ShowDialog();
        }

        private void btnPerDos_Click(object sender, RoutedEventArgs e)
        {

            Puzzle finestra = new Puzzle(2);
            finestra.ShowDialog();
        }
    }
}
