using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Parelles
{
    /// <summary>
    /// Lógica de interacción para Puzzle.xaml
    /// </summary>
    public partial class Puzzle : Window
    {
        public Puzzle(int numero)
        {
            InitializeComponent();
            Button primerClick = null;
            Button segonClick = null;
            //Button tercerClick = null;
            int contadorClicks = 0;
            Timer timer = new Timer();
            timer.Interval = 2500;
            timer.Enabled = false;
            timer.Elapsed += Timer_Elapsed;
            
            string[] abecedari = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "U", "V", "W", "X", "Y", "Z" };
            Random r = new Random();
            List<TextBlock> parellesDesordenades = new List<TextBlock>();
            List<TextBlock> parellesDeLletres = new List<TextBlock>();
            int nums;
            if (numero == 2) nums = 2;
            else if (numero == 4) nums = 8;
            else nums = 18;

            #region Creacio de Columnes i Files
            for (int i = 0; i < numero; i++)
            {
                RowDefinition row = new RowDefinition();
                ColumnDefinition column = new ColumnDefinition();
                grdPuzzle.RowDefinitions.Add(row);
                grdPuzzle.ColumnDefinitions.Add(column);
            }
            //Content = grdPuzzle;
            #endregion

            #region Creacio de la llista i desordenarla
            //Creacio de txtblocks i afegirlos a la llista
            for (int j = 0; j < nums; j++)
            {
                string lletra = abecedari[r.Next(25)];
                for (int i = 0; i < 2; i++)
                {
                    TextBlock txt = new TextBlock();
                    txt.FontSize = 40;
                    txt.HorizontalAlignment = HorizontalAlignment.Center;
                    txt.VerticalAlignment = VerticalAlignment.Center;
                    txt.Text = lletra;
                    parellesDeLletres.Add(txt);
                }
            }


            //Llista desordenada

            while (parellesDeLletres.Count > 0)
            {
                int val = r.Next(0, parellesDeLletres.Count - 1);
                parellesDesordenades.Add(parellesDeLletres[val]);
                parellesDeLletres.RemoveAt(val);
            }

            #endregion

            #region Agregacio textblocks/buttons al grid

            //Agregacio dels textblocks al grid
            int ind = 0;
            for (int i = 0; i < numero; i++)
            {
                for (int j = 0; j < numero; j++)
                {
                    Grid.SetColumn(parellesDesordenades[ind], j);
                    Grid.SetRow(parellesDesordenades[ind], i);
                    grdPuzzle.Children.Add(parellesDesordenades[ind]);
                    ind++;
                }
            }
            //Agregacio dels buttons al grid
            int indexBtn = 0;
            for (int i = 0; i < numero; i++)
            {
                for (int j = 0; j < numero; j++)
                {
                    Button btn = new Button();
                    btn.Click += Btn_Click;
                    btn.Tag = parellesDesordenades[indexBtn].Text;
                    Grid.SetRow(btn, i);
                    Grid.SetColumn(btn, j);
                    grdPuzzle.Children.Add(btn);
                    indexBtn++;
                }
            }
            #endregion


            //Funcio Button click
            void Btn_Click(object sender, RoutedEventArgs e)
            {

                contadorClicks++;
                txtNumIntents.Text = contadorClicks.ToString();
                Button btn = (Button)sender;
                if (primerClick == null)
                {
                    primerClick = btn;
                    primerClick.Visibility = Visibility.Hidden;

                }
                else
                {
                    segonClick = btn;
                    segonClick.Visibility = Visibility.Hidden;
                    
                    if (primerClick.Tag==segonClick.Tag)
                    {
                        primerClick = null;
                        segonClick = null;
                        
                    }
                    else
                    {
                        foreach (Object control in grdPuzzle.Children)
                        {
                            if (control is Button)
                            {
                                Button buto = (Button)control;
                                buto.IsEnabled = false;
                            }
                        }
                        timer.Start();
                        


                        //foreach (Control control in grdPuzzle.Children)
                        //{
                        //    if (control is Button)
                        //    {
                        //        Button buto = (Button)control;
                        //        buto.IsEnabled = true;
                        //    }



                        //}

                    }
                    
                    //if (segonClick.Tag == primerClick.Tag)
                    //{
                    //    segonClick = null;
                    //    primerClick = null;
                    //}
                    //else
                    //{
                    //primerClick.Visibility = Visibility.Visible;
                    //segonClick.Visibility = Visibility.Visible;
                    //segonClick = null;
                    //primerClick = null;
                    //}
                }
            }
           
            //Funcio Timer
            void Timer_Elapsed(object sender, ElapsedEventArgs e)
            {
                this.Dispatcher.Invoke(() =>
                {
                    foreach (Object control in grdPuzzle.Children)
                    {
                        if (control is Button)
                        {
                            Button buto = (Button)control;
                            buto.IsEnabled = true;
                        }
                    }
                    primerClick.Visibility = Visibility.Visible;
                   primerClick = null;
                   segonClick.Visibility = Visibility.Visible;  
                   segonClick = null;
                        
                    
                });
                timer.Stop();
            }
        }

       
    }
}
