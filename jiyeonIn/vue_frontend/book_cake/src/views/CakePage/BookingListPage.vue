<template>
    <div class="Main">
       <header>
            <router-link style="text-decoration: none;" :to="{name: 'MainHomepage'}">            
                <v-img class="MainLogo"
                max-height="200" max-width="250" 
                src="@/assets/img/check.png"/>
            </router-link>
        </header>
        <hr>
         <v-container >
            <v-row no-gutters class="menu">
                <v-col class="col-12 col-sm-3"></v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'BookingPage'}">
                        <p>예약하기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'BookingListPage'}">
                        <p>주문서 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                    <router-link :to="{name: 'PreviewCakeImg'}">
                        <p>케이크 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                   <router-link :to="{name: 'ReviewPage'}">
                        <p>후기</p>
                    </router-link>
                </v-col>
            </v-row>
        </v-container>
        
        <div class="wrap">
            <h3>주문서 리스트</h3>
            <br>
            

        </div>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.wrap {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}


</style>