using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculadora.ViewModels
{
    public class MainPageVM : clsVMBase
    {
        #region Atributos
        private string resultado;
        private DelegateCommand numerosCommand;
        private DelegateCommand demasCommand;
        #endregion

        #region Constructores
        public MainPageVM() 
        {
            this.resultado = "0";
            
        }
        #endregion

        #region Propiedades
        public string Resultado { 
            get { return this.resultado; } 
            private set 
            { 
                if (resultado != value)
                {
                    resultado = value;
                    NotifyPropertyChanged(nameof(resultado));
                } 
            } 
        }

        public DelegateCommand NumerosCommand
        {
            get { return numerosCommand; }
        }

        public DelegateCommand DemasCommand
        {
            get { return demasCommand; }
        }
        #endregion

        #region Comandos
        private void numerosCommandExecute()
        {
            
        }

        private void demasCommandExecute()
        {

        }
        #endregion
    }
}
