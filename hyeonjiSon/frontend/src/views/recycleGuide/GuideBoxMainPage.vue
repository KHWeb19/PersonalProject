<template>
    <div align="center">
        <br>
        <v-container style="width: 1000px">
                        <v-row justify="center">
                
                <v-btn id="btn2" @click="goMain">돌아가기</v-btn>
                <v-spacer></v-spacer>
                <v-btn id="btn" @click="goCloth">의류 수거함</v-btn>
                &ensp;

                <v-dialog  v-model="findPw" resisten max-width="500px">
                    <template v-slot:activator="{ on }">
                        <v-btn id="btn" @click="goBattery" v-on="on" >폐형광등 수거함</v-btn>
                    </template>

                        <v-card align="center">
                            <v-img src="@/assets/updating.jpg"/> 
                        <br>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn style="background-color: darkKhaki; color: white; " text @click.native="btn_click($event)">
                                    OK
                                </v-btn>
                            </v-card-actions>
                        </v-card>

                </v-dialog>  
            </v-row>

                        <br><br>
                            <img src="@/assets/guidePage/boxNotice.jpg"/>


        </v-container>
    </div>
</template>

<script>

export default {
    name: 'guideBoxMainPage',
    methods: {
        goMain(){
            this.$router.push({ name: 'recycleGuideMainPage' })
        },
        goCloth(){
            this.$router.push({ name: 'boxClothPage' })
        } 
    }
}
</script>

<style scoped>
#btn{
    color: white;
    background-color: #ccbce3;
    width: 180px;
    box-shadow: none;  
}
#btn2{
    color: white;
    background-color: darkkhaki;
    width: 120px;
    box-shadow: none;  
}
</style>