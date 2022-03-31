<template>
<v-app>
<app-bar />   
<v-main>
  <!-- 레이아웃 손보면 될듯  -->
  <v-form @submit.prevent="onSubmit">
       <v-text-field
            label="상품명을 입력하세요."
        ></v-text-field>

        <v-text-field
            label="숫자만 입력하세요."
          suffix="원"
        ></v-text-field>

          <v-autocomplete
            ref="region"
            v-model="region"
            :rules="[() => !!regiㄴon || '필수 입력 항목입니다']"
            :items="region"
            label="거래 지역"
            placeholder="선택해주세요"
            required
          ></v-autocomplete>
           
          <v-text-field
            label="희망 직거래 장소를 입력하세요."
            prepend-icon="mdi-map-marker"
          ></v-text-field>

           <v-textarea
            label="상품 설명을 입력하세요."
            counter
            maxlength="1000"
            full-width
            single-line
          ></v-textarea>



  </v-form>

</v-main>
</v-app>
</template>

<script>
import AppBar from '@/components/core/AppBar'
export default {
  components: { AppBar },
    name: 'uploadProduct'
}
</script>

<style>

</style>