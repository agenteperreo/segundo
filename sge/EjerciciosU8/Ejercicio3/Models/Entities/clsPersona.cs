namespace Ejercicio3.Models.Entities
{
    public class clsPersona
    {
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string Tlfno { get; set; }

        public clsPersona() { }

        public clsPersona(string nombre, string apellidos, string tlfno)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
            this.Tlfno = tlfno;
        }
    }
}
