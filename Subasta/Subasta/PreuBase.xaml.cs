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
using System.Windows.Shapes;

namespace Subasta
{
    /// <summary>
    /// Lógica de interacción para Resultat.xaml
    /// </summary>
    public partial class PreuBase : Window
    {
        public PreuBase()
        {
            InitializeComponent();        
        }

        private void btnTanca_Click(object sender, RoutedEventArgs e)
        {
            MainWindow finestra = (MainWindow)Owner;
            finestra.NomArticle = txtNomArticle.Text;
            finestra.PreuMinim = Convert.ToInt32(txtPreuMinim.Text);
            this.Close();
        }
    }
}
