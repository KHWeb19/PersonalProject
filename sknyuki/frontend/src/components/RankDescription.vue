<template>
<div>
    <v-card class="mt-9 pa-2" align="center">  
       <h3>랭크설명표</h3>
        <br>
        <v-row>
            <v-col>
                <h3>SA</h3>
            </v-col>
            <v-col>
                <h3>구매후 미개봉 제품</h3>
            </v-col>
        </v-row>
        <v-row>
            <v-col>
                <h3>A</h3>
            </v-col>
            <v-col>
                <h3>사용은 하였으나 미사용품에 가까운 제품</h3>
            </v-col>
        </v-row>
        <v-row>
            <v-col>
                <h3>AB</h3>
            </v-col>
            <v-col>
                <h3>사용감이 적은 미품٠다소의 데미지가 있음</h3>
            </v-col>
        </v-row>
        <v-row>
            <v-col>
                <h3>B</h3>
            </v-col>
            <v-col>
                <h3>다소의 상처나 더러움은 있으나 정도가 좋은 제품 </h3>
            </v-col>
        </v-row>
        <v-row>
            <v-col>
                <h3>BC</h3>
            </v-col>
            <v-col>
                <h3>다소 상처 및 더러움이 눈에 띄는 제품</h3>
            </v-col>
        </v-row>
        <v-row>
            <v-col>
                <h3>C</h3>
            </v-col>
            <v-col>
                 <h3>전체적으로 상당한 사용감이 있으며 눈에 띄는 상처가 다수 있는 제품 </h3>
            </v-col>
        </v-row>
    </v-card>

   
       
</div>
</template>
<script>
export default {
    name:'RankDescription',
}
</script>