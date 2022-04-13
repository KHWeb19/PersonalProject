<template>
    <div>
        <v-container>
        <v-layout class="mx-auto">
            <v-img contain class="responsive-img" src="../assets/main/test.jpg"/>
            <v-img contain class="deco responsive-img" src="../assets/main/mainTitle.png"/>
        </v-layout>
        </v-container>
        
    </div>
</template>



<script>


export default {
    name: 'MainVellupPage',
    components: {
    
     
    },


}
</script>

<style scoped>
.mx-auto {
    margin-top: 10px;
    width:70%;
}
.deco {
    position:absolute; 
    top:35%; left:17%; width:35%;
}
</style>