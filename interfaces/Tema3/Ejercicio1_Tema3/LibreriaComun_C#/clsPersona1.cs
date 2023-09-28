using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LibreriaComun_C_
{
    internal class clsPersona1
    {
        #region atributos
        private String nombre;
        private String apellidos;
        #endregion

        #region constructores
        public clsPersona1()
        {
            nombre = "";
            apellidos = "";
        }

        public clsPersona1(String nombre, String apellidos)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        #endregion

        #region propiedades
        public String Nombre { get { return nombre; } set { nombre = value; } }
        public String Apellidos { get {  return apellidos; } set {  apellidos = value; } }
        public int Direccion { get; set; }
        public String NombreCompleto 
        { 
            get
            {
                return nombre + " " + apellidos;
            } 
        }
        #endregion
    }
}