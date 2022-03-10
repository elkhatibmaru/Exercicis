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
    /// Lógica de interacción para Licita.xaml
    /// </summary>
    public partial class Licita : Window
    {
        public int Preu { get; set; }
        public Licita()
        {
            InitializeComponent();
        }

        private void btnTanca_Click(object sender, RoutedEventArgs e)
        {
            MainWindow finestra = (MainWindow)Owner;
            Preu = Convert.ToInt32(txtQuantitat.Text);
            finestra.Persones.Add(new Persona() { Nom = txtNom.Text, Quantitat = Preu });
            if(Preu>finestra.PreuMinim)
            {
                finestra.Venut = true;
                finestra.PreuMinim = Preu;
                finestra.NomPersona = txtNom.Text;
            }
            this.Close();
        }
    }
}
