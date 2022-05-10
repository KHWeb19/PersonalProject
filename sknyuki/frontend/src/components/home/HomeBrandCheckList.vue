
<template>
    <v-container>
    <v-row align="center" justify="center">
    <router-link style="text-decoration: none;" :to="{name:'K1CheckBrandView'}">
    <v-btn class="blue lighten-5">상품 판별 보러가기 </v-btn>
    </router-link></v-row>
<br>
 <div class="brand-img">
   
                
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'HERMES' } }" class="item hover item1"></router-link>
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'VITTON' }}" class="item hover item2"></router-link>
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'CHANEL' }}" class="item hover item3"></router-link>
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'GUCCI' }}" class="item hover item4"></router-link>
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'PRADA' }}" class="item hover item5"></router-link>
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'ROLEX' }}" class="item hover item6"></router-link>
                  <router-link :to="{name:'K1CheckBrandView',params: { brand: 'Others' }}" class="item hover item7"></router-link>
                </div>
                
    </v-container>
</template>

<script>
export default {
    name:'HomeBrandCheckList',

}
</script>

<style scoped>
.brand-img{
   width: 100%;
  height: 300px;
  
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
}
.item {
  flex: 1;
  height: 100%;
  background-position: center;
  background-size: cover;
  background-repeat: none;
  transition: flex 0.8s ease;
  }
    
.hover:hover {
    flex: 2;
  }

.item1 { 
  background-image: url('https://i.pinimg.com/564x/3f/50/df/3f50dfb5a9ab81e54e30378252a9bfc3.jpg');
}
.item2 { 
  background-image: url('https://i.pinimg.com/564x/16/eb/21/16eb218c3ba8e96de14141f9101998e6.jpg');
}
.item3 { 
  background-image: url('https://i.pinimg.com/564x/41/65/69/416569694aaad562c6505b8d60e31379.jpg');
}
.item4 { 
  background-image: url('https://i.pinimg.com/564x/69/98/99/699899f96aad2ef5bcbd01673b0ffddc.jpg');
}
.item5 { 
  background-image: url('https://i.pinimg.com/564x/c2/80/4b/c2804bc8d419280fbd818b2006792ae6.jpg');
}
.item6 { 
  background-image: url('https://previews.123rf.com/images/buschmen/buschmen1412/buschmen141200303/34914999-%ED%94%84%EB%9D%BC%ED%95%98-%EC%B2%B4%EC%BD%94-2014-%EB%85%84-9-%EC%9B%94-18-%EC%9D%BC-%EB%A1%A4%EB%A0%89%EC%8A%A4-%EB%B6%80%ED%8B%B0%ED%81%AC-%EA%B2%80%EC%A0%95%EC%83%89%EA%B3%BC-%ED%9D%B0%EC%83%89-%EB%A1%A4%EB%A0%89%EC%8A%A4%EB%8A%94-%EC%8A%A4%EC%9C%84%EC%8A%A4-%ED%9A%8C%EC%82%AC%EC%97%90%EC%84%9C-%EA%B3%A0%EA%B8%89-%EC%8B%9C%EA%B3%84%EB%A5%BC-%EC%83%9D%EC%82%B0%ED%95%A9%EB%8B%88%EB%8B%A4-%EC%97%B0%EA%B0%84-%EB%A7%A4%EC%B6%9C-74-%EC%96%B5-%EB%8B%AC%EB%9F%AC-%EC%9D%B4%EC%83%81.jpg');
}
.item7 { 
  background-image: url('https://urala.today/wp-content/uploads/2020/03/6155583013a3fb3ca950a1a9aaaa76aa-1.jpg');
}
</style>