namespace Ejercicio12y3.Models.Entidades
{
    public class clsPersona
    {
        #region Atributos
        public string Nombre { get; set; }
        public string Apellidos { get; set; }

        public string Telefono { get; set; }
        #endregion

        #region Constructores
        public clsPersona() { }

        public clsPersona(string nombre, string apellidos, string telefono)
        {
            Nombre = nombre;
            Apellidos = apellidos;
            Telefono = telefono;
        }
        #endregion
    }
}
