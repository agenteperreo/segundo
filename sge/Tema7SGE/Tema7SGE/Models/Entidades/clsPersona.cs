namespace Tema7SGE.Models.Entidades
{
    public class clsPersona
    {

        #region Propiedades
        public String nombre { get; set; }
        public String apellidos { get; set; }
        public String telefono {  get; set; }
        #endregion

        #region Contructores
        public clsPersona()
        {
            nombre = "";
            apellidos = "";
            telefono = "";
        }

        public clsPersona(string nombre, string apellidos, string telefono)
        {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.telefono = telefono;
        }
        #endregion
    }
}
