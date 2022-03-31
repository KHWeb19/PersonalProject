<template>
    <v-menu open-on-hover>
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            icon
            v-bind="attrs"
            v-on="on"
          >
            <v-icon>mdi-dots-vertical</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item link>
            <v-list-item-content>
              <v-list-item-title class="text-h6">
                Sandra Adams
              </v-list-item-title>
              <v-list-item-subtitle>sandra_a88@gmail.com</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list
          nav
          dense
        >
          <v-list-item-group
            color="deep-orange" 
          >
            <v-list-item class="hidden-sm-and-up">
              <v-list-item-icon>
                 <v-icon> mdi-magnify </v-icon>
              </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title> 상품 검색하기 </v-list-item-title>
            </v-list-item-content>
            </v-list-item>
  
            <v-list-item
            v-for="(item, i) in user"
            :key="i"
          >
            <v-list-item-icon>
              <v-icon v-text="item.icon"></v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title v-text="item.text"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          </v-list-item-group>
        </v-list>
    </v-menu>
</template>
<script>
export default {
    name: 'dotsMenu',
    data: () => ({
       user : [
        { text: '메인 화면으로 가기', icon: 'mdi-home' },
        { text: '마이 페이지', icon: 'mdi-account' },
        { text: '찜한 상품 보기', icon: 'mdi-heart' },
        { text: '내가 작성한 글 보기', icon: 'mdi-history' }
      ]
    }),
}
</script>