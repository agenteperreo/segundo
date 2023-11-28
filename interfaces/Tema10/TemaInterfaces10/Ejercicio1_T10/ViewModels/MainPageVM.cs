using Ejercicio1_T10.Models.DAL;
using Ejercicio1_T10.Models.Entidades;
using Ejercicio1_T10.ViewModels.Utilidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio1_T10.ViewModels
{
    public class MainPageVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand buscarCommand;
        private DelegateCommand eliminarCommand;
        private ObservableCollection<clsPersona> listadoPersonas;
        private clsPersona personaSeleccionada;
        private String textoBusqueda;
        #endregion

        #region Constructores
        public MainPageVM()
        {
            listadoPersonas = new ObservableCollection<clsPersona>(ListaPersonas.listadoCompletoPersonas());
            buscarCommand = new DelegateCommand(buscarCommandExecute, buscarCommandCanExecute);
            eliminarCommand = new DelegateCommand(eliminarCommandExecute, eliminarCommandCanExecute);
        }
        #endregion

        #region Propiedades
        public DelegateCommand BuscarCommand 
        { 

            get { return buscarCommand; }

        }

        public DelegateCommand EliminarCommand
        {
            get { return eliminarCommand; }
        }

        public ObservableCollection<clsPersona> ListadoPersonas
        {

            get { return listadoPersonas; }

        }

        public clsPersona PersonaSeleccionada
        {
            set { personaSeleccionada = value;
                NotifyPropertyChanged("PersonaSeleccionada");
                eliminarCommand.RaiseCanExecuteChanged();
            }
        }

        public String TextoBusqueda
        {
            get { return textoBusqueda; }

            set { textoBusqueda = value;
                NotifyPropertyChanged("TextoBusqueda");
                buscarCommand.RaiseCanExecuteChanged();
            }
        }
        #endregion

        #region Comandos
        /// <summary>
        /// Metodo asociado al 
        /// </summary>
        /// <returns>bool habilitado</returns>
        private bool eliminarCommandCanExecute()
        {
            bool habilitadoEliminar = false;

            if(personaSeleccionada != null)
            {
                habilitadoEliminar = true;
            }

            return habilitadoEliminar;
        }

        /// <summary>
        /// 
        /// </summary>
        private void eliminarCommandExecute()
        {
           listadoPersonas.Remove(personaSeleccionada);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        private bool buscarCommandCanExecute()
        {
            bool habilitadoBuscar = true;

            if(String.IsNullOrEmpty(textoBusqueda))
            {
                habilitadoBuscar = false;
            }

            return habilitadoBuscar;
        }

        /// <summary>
        /// 
        /// </summary>
        private void buscarCommandExecute()
        {
            var listadoFiltrado = listadoPersonas.Where(p => p.Nombre.Contains(textoBusqueda) || p.Apellidos.Contains(textoBusqueda)).ToList();
            listadoPersonas = new ObservableCollection<clsPersona> (listadoFiltrado);
            NotifyPropertyChanged("ListadoPersonas");
        }
        #endregion

        #region Metodos y Funciones
        #endregion
    }
}
