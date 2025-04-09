import { View, Text, StyleSheet } from "react-native"

export default function CompView(){
    return(
        <View>
            <Text style={styles.titulo}>Titulo</Text>
            <Text style={{fontSize:20,color:"red",fontWeight:900,textTransform:"uppercase"}}>Hola mundo</Text>
            <Text style={styles.baseTexto}>
                Texto en negrita
                <Text style={styles.textoInterno}>
                    y en rojo
                </Text>
            </Text>
        </View>
    )
}

const styles = StyleSheet.create(
    {
        titulo:{
            marginTop:16,
            paddingVertical:8,
            borderWidth:3,
            borderColor:'#20232a',
            borderRadius: 6,
            backgroundColor: '#61dafb',
            color:  '#20232a',
            textAlign: 'center',
            fontSize:20,
            fontWeight:'bold'
        },
        baseTexto:{
            marginTop:10,
            fontWeight:'bold',
            fontSize:20
        },
        textoInterno:{
            color:'red'
        }
    }
)