<template>
    <body>            
        <v-container fluid>
            <v-window show-arrows>
               
                <v-window-item :value="1">
                    <v-card >
                        <v-img src="@/assets/picture/mainimg.png" height="950">

                            <v-row class="fill-height pa-4" align="center">
                                
                                <v-col cols="12" md="7" offset-md="1">
                                    <h1 class="display-2 mb-30 font-weight-light white--text">Warm, Tranquil Living</h1>

                                    <div class="pl-2 mt-2 white--text">
                                        relax your life
                                    </div>
                                    
                                </v-col>
                            </v-row>
                        </v-img>
                    </v-card>
                </v-window-item>
            </v-window>
        </v-container>

        <div class="contents">
            <h1>Welcome home</h1>
            <p></p>
            <h3> Sophisticated modern interiors provide perfectly proportionend places</h3>
        </div>


        <div class="screen">
            <div class="top" >
                <h3>Warm, Tranquil Living</h3>
                </div>
            <div class="bottom">
                <p> 아름다운 실내에서 <br>
                행복한 라이프를 즐기세요 </p>
            </div>
            <v-img src="@/assets/picture/aptinner.jpg" height="700"></v-img>
        </div>
        <p></p>
        <div class="screen2">
            <div class="top2" >
                <h3>Warm, Tranquil Living</h3>
                </div>
            <div class="bottom2">
                <p> 아름다운 실내에서 <br>
                행복한 라이프를 즐기세요 </p>
            </div>
            <v-img src="@/assets/picture/kids.png" height="700"></v-img>
        </div>
    <!--
            <v-sheet class="mt-5 mb-10">
                <v-row>
                    <v-col cols="12" md="7">
                        <weather></weather>
                    </v-col>
                </v-row>
            </v-sheet>  -->
    <weather></weather>
    <br><br>
    
    </body>
    
   
</template>
         

<script>

import Weather from '@/components/main/Weather.vue'
//import FooterForm from '@/components/main/FooterForm.vue'



export default {

    name: 'MainPage',

  components:

    {   Weather,
        //FooterForm 
    },
   
  data() {
    return {
        nav_drawer:'',
        group:'',
        category:''
      
    }
}
}


//@import url('https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&display=swap');'Dancing Script', cursive;
//@import url('https://fonts.googleapis.com/css2?family=Parisienne&display=swap'); color: rgba(230, 215, 89, 0.897);
//font-family: 'Cinzel', serif;  @import url('https://fonts.googleapis.com/css2?family=Cinzel&display=swap');

</script>


<style scoped>
 
 @import url('https://fonts.googleapis.com/css2?family=Poiret+One&display=swap');

*{  margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.contents {
    font-family: 'Poiret One', cursive;
    text-align: center;
    margin: 5% 0% 5% 0%;
    padding: 5px 0px 5px 0px;
}



.screen{
    position: relative;
    overflow: hidden;   
}
.top{
    font-family: 'Poiret One', cursive;
    position:absolute;
    bottom:150%;
    left:30px;
    z-index: 2;
    color:white;
    font-size: 30px;
    transition: all .35s;    
}
.bottom{
    
    position:absolute;
    top:150%;
    left:30px;
    z-index: 2;
    color:white;
    font-size: 20px;
    transition: all .35s;
}
.screen:hover .top{top: 30%;}
.screen:hover .bottom{top: 70%;}

.screen::after {
    content:'';
    display: block;
    position: absolute;
    top:0;
    left:0;
    width:30%;
    height:100%;
    background:rgba(0, 0, 1, 0.329);
    z-index: 1;
    opacity: 0;
    transition: all .35s;
}
.screen:hover::after{
    opacity: 1;
}



.screen2{
    position: relative;
    overflow: hidden;   
}
.top2{
    font-family: 'Poiret One', cursive;
    position:absolute;
    bottom:150%;
    right:30px;
    z-index: 2;
    color:white;
    font-size: 30px;
    transition: all .35s;    
}
.bottom2{   
    position:absolute;
    top:150%;
    right:30px;
    z-index: 2;
    color:white;
    font-size: 20px;
    transition: all .35s;
}
.screen2:hover .top2{top: 30%;}
.screen2:hover .bottom2{top: 70%;}

.screen2::after {
    content:'';
    display: block;
    position: absolute;
    top:0;
    right:0;
    width:30%;
    height:100%;
    background:rgba(0, 0, 1, 0.329);
    z-index: 1;
    opacity: 0;
    transition: all .35s;
}
.screen2:hover::after{
    opacity: 1;
}
.login{
    text-decoration: none;  
    
    font-size: 20px;
    padding-top: 23px;
    margin-right: 30px;
}
.register{
    text-decoration: none;  
    font-weight: light; 
    font-size: 20px;
    padding-top: 23px

}

</style>

