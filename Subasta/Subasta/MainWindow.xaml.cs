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

namespace Subasta
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public bool Venut { get; set; } = false;
        public List<Persona> Persones { get; set; } = new List<Persona>();
   
        public string NomArticle { get; set; }

        public int PreuMinim { get; set; }

        public string NomPersona { get; set; } 

        public MainWindow()
        {
            InitializeComponent();
        }

        private void btnPreuBase_Click(object sender, RoutedEventArgs e)
        {
            PreuBase finestra = new PreuBase();
            finestra.Owner = this;
            finestra.ShowDialog();
            btnPreuBase.IsEnabled = false;
            
        }

        private void btnLicita_Click(object sender, RoutedEventArgs e)
        {
            Licita finestra = new Licita();
            finestra.Owner=this;
            finestra.ShowDialog();
        }

        private void btnResultat_Click(object sender, RoutedEventArgs e)
        {
            Resultat finestra = new Resultat();
            finestra.txtPreu.Text = PreuMinim.ToString();
            finestra.txtNom.Text = NomPersona;
            if(!Venut)
            {
                finestra.txtArticle.Text = "No s'ha venut l'article";
                finestra.txtPer.Text = "Preu Base";
            }
            else
            {
                for (int i = 0; i < Persones.Count; i++)
                {
                    TextBlock nomPersona = new TextBlock();
                    TextBlock quantiatPers = new TextBlock();
                    DockPanel dock = new DockPanel();
                   
                    nomPersona.Text = Persones[i].Nom;
                    quantiatPers.Text = Persones[i].Quantitat.ToString();
                    nomPersona.FontSize = 50;
                    quantiatPers.FontSize = 50;

                    DockPanel.SetDock(quantiatPers, Dock.Right);
                    dock.Children.Add(quantiatPers);
                    dock.Children.Add(nomPersona);
                   

                    finestra.stkTot.Children.Add(dock);
                    

                }
            }
           
            
            finestra.ShowDialog();
        }
    }

   
}
