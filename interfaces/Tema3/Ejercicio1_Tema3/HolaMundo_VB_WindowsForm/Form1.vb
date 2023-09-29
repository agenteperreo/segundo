Public Class Form1
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub btnSaludar_Click(sender As Object, e As EventArgs) Handles btnSaludar.Click

        Dim nombre As String

        Dim clsPersona As New clsPersona()

        MessageBox.Show("Hola", "saludo")
    End Sub

End Class
