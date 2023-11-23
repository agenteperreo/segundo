using Ejercicio1_T10.Models.DAL;
using Ejercicio1_T10.Models.Entidades;
using Ejercicio1_T10.ViewModels.Utilidades;
using System;
using System.Collections.Generic;
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
        private List<clsPersona> listadoPersonas;
        private clsPersona personaSeleccionada;
        private String textoBusqueda;
        #endregion

        #region Constructores
        public MainPageVM()
        {
            listadoPersonas = ListaPersonas.listadoCompletoPersonas();
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

        public List<clsPersona> ListadoPersonas
        {

            get { return listadoPersonas; }

        }

        public clsPersona PersonaSeleccionada
        {
            set { personaSeleccionada = value; }
        }

        public String TextoBusqueda
        {
            get { return textoBusqueda; }
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
            NotifyPropertyChanged("ListadoPersonas");
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
            
        }
        #endregion

        #region Metodos y Funciones
        #endregion
    }
}
