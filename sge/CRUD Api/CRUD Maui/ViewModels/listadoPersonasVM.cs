using CRUD_Maui.ViewModels.Utilidades;
using DAL.Listados;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CRUD_Maui.ViewModels
{
    public class listadoPersonasVM : clsVMBase
    {
        #region Atributos
        private ObservableCollection<clsPersona> listadoPersonas;
        private clsPersona personaSeleccionada;
        private DelegateCommand elegirCommand;
        #endregion

        #region Constructores
        public listadoPersonasVM()
        {
            listadoPersonas = new ObservableCollection<clsPersona>(clsListadoPersonas.getPersonasDAL().Result);
        }
        #endregion

        #region Propiedades
        public ObservableCollection<clsPersona> ListadoPersonas
        {
            get { return listadoPersonas; }
        }

        public clsPersona PersonaSeleccionada
        {
            set
            {
                personaSeleccionada = value;
                NotifyPropertyChanged("PersonaSeleccionada");
            }
        }

        public DelegateCommand ElegirCommand
        {
            get { return elegirCommand; }
        }
        #endregion

        #region Comandos
        private bool elegirCommandCanExecute()
        {
            bool habilitadoElegir = false;

            if(personaSeleccionada != null)
            {
                habilitadoElegir = true;
            }

            return habilitadoElegir;
        }

        private void elegirCommandExecute()
        {
            
        }
        #endregion
    }
}
