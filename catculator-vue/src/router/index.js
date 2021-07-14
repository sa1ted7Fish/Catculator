import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '@/views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'HomePage',
    component: Home,
    redirect: '/home',
  },
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/menu',
    name: 'Menu',
    component: () => import('@/views/Menu')
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('@/views/About')
  },
  {
    path: '/initial-cost',
    name: 'InitialCost',
    component: () => import('@/views/InitialCost')
  },
  {
    path: '/monthly-cost',
    name: 'MonthlyCost',
    component: () => import('@/views/MonthlyCost')
  },
  {
    path: '/irregular-cost',
    name: 'IrregularCost',
    component: () => import('@/views/IrregularCost')
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
