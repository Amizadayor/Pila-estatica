import javax.swing.JOptionPane; // Importamos la libreriria para los mensajes de dialogo

public class PilaEstatica{ // creamos la clase de la pila estatica
    int vectorPila[]; // declaramos  las varibles a utilizar
    int cima;
                                      // Hacemos el onstructor
    public PilaEstatica(int tamanio){
        vectorPila = new int [tamanio];
        cima = -1;   //En esta parte la primera posicion se iniciara en menos uno para saber cuando esta vacia.
    }
                                     // Metodo de insertar
    public void Insertar(int dato){
        cima++;
        vectorPila[cima] = dato;  //le damos un dato en la cima de la pila
    }
                                     // Metodo de eliminar
    public int Eliminar(){
        int afuera = vectorPila[cima];
        cima--;
        return afuera;
    }
                                    //metodo para saber si la pila esta vacia
    public boolean estaVacia(){
        return cima == -1;
    }
                                    //metodo para saber cuando la pila se encuentre llena
    public boolean estaLLena(){
        return vectorPila.length-1 == cima;
    }
                                    //metodo para saber que elemento se encuentra en la cima de la pila
    public int cimaPila(){
        return vectorPila[cima];
    }
                                    //Metodo para saber el tamaño de la pila
    public int tamanioPila(){
        return vectorPila.length;
    }

    public static void main(String [] args){
        int opcion = 0, elemento, tamanio;
        boolean estado = false;
        try{
            tamanio = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EL TAMANIO DE LA PILA ", "SOLICITANDO EL TAMANIO",
            JOptionPane.INFORMATION_MESSAGE));
            PilaEstatica pe = new PilaEstatica(tamanio);
            do{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                "1. INGRESAR ELEMENTO A LA PILA \n"
                + "2. ELIMINAR ELEMENTO DE LA PILA \n"
                + "3. LA PILA ES VACIA ?\n"
                + "4. LA PILA ESTA LLENA ?\n"
                + "5. ELEMENTO EN LA CIMA DE LA PILA \n"
                + "6. TAMANIO DE LA PILA\n"
                + "7. SALIR \n"
                + " DIGITE SU OPCION DEL MENU ", JOptionPane.INFORMATION_MESSAGE));
                switch(opcion){
                    case 1:
                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE EL DATO A INCORPORAR A LA PILA",
                    JOptionPane.INFORMATION_MESSAGE));
                    if(!pe.estaLLena()){
                        pe.Insertar(elemento);
                    }else{
                        JOptionPane.showMessageDialog(null," LA PILA ESTA LLENA");
                    }
                    break;
                    case 2:
                    if(!pe.estaVacia()){
                        JOptionPane.showMessageDialog(null," EL ELEMENTO OBTENIDO ES " + pe.Eliminar());
                    }else{
                        JOptionPane.showMessageDialog(null," LA PILA ESTA VACIA ");
                    }
                    break;
                    case 3:
                    if(pe.estaVacia()){
                        JOptionPane.showMessageDialog(null," LA PILA ESTA VACIA ");
                    }else{
                        JOptionPane.showMessageDialog(null," LA PILA NO ESTA VACIA ");
                    }
                    break;
                    case 4:
                    if(pe.estaLLena()){
                        JOptionPane.showMessageDialog(null," LA PILA ESTA LLENA");
                    }else{
                        JOptionPane.showMessageDialog(null,"LA PILA NO ESTA LLENA");
                    }
                    break;
                    case 5:
                    if(!pe.estaVacia()){
                        JOptionPane.showMessageDialog(null,"EL ELEMENTO QUE ESTA EN LA CIMA DE LA PILA ES  " + pe.cimaPila());
                    }else{
                        JOptionPane.showMessageDialog(null,"LA PILA ESTA VACIA");
                    }
                    break;
                    case 6:
                    JOptionPane.showMessageDialog(null,"EL TAMANIO DE LA PILA ES : " + pe.tamanioPila());
                    break;
                    case 7: JOptionPane.showMessageDialog(null,"PROGRAMA FINALIZADO");
                    break;
                    default:JOptionPane.showMessageDialog(null,"ERROR, ESTA OPCION NO ES CORRECTA");
                }
            }while(opcion != 7);
        }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null," INGRESE SOLO NUMEROS " + n.getMessage());
        }
    }
}