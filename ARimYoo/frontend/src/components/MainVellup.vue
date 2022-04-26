<template>
    <v-container>
        <v-row justify="center">
            <input type="text" class="mainSearch">
            <v-btn class="searchBtn" @click=goSearch color="red darken-3" dark>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
            </v-btn>
        </v-row>
        <br/>
        <v-row class="imgGallery">
            <v-col>
                <img src="@/assets/main/main4.jpg" style="width:250px"/>
            </v-col>
            <v-col>
                <img src="@/assets/main/main3.png" style="width:250px"/>
            </v-col>
            <v-col>
                <img src="@/assets/main/main2.png" style="width:250px"/>
            </v-col>
            <v-col>
                <img src="@/assets/main/main1.png" style="width:250px"/>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name:'MainVellup'
}
</script>
<style scoped>
.mainSearch{
    border-radius:5px;
    position: relative;
    width:400px;
    height:38px;
    background-color: rgb(240, 238, 238);
    outline-color: rgb(211, 32, 32);
    padding-left:10px;
    font-family: 'Noto Sans KR', sans-serif;
    float:left;
}
.imgGallery{
    margin-top:3%;
    margin-left:auto;
    margin-right:auto;
}
</style>