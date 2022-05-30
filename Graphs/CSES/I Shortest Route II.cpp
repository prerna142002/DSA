#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define ld long double
#define mod 1000000007
#define inf 100000000000000 
#define pb push_back
#define pii pair<int,int>
#define endl '\n'
//1<<X means 2^X 
int main()
{
            ll n, m , q;
            cin>>n>>m>>q;
            
            vector<vector<ll> > mat(n+1, vector<ll> (n+1, inf));
            for(int i=1;i<=n;i++)
            {
              mat[i][i] = 0;  
            }
            
            for(int i=0;i<m;i++)
            {
              ll a1, a2, a3;
              cin>>a1>>a2>>a3;
              
              mat[a1][a2] = min(mat[a1][a2],a3);
              mat[a2][a1] = min(mat[a2][a1],a3);
            }
            
            int ite = n;
//            if( n >= 400 ) {
//              ite = 399;
//            }     
            
            int dup = 0;
  for(int i=1;i<=ite;i++)
            {
              // boolean change = false;
              for(int x=1;x<=n;x++)
              {
                // if( x == i) continue;
                for(int y=1;y<=n;y++)
                {
//                  if(x == y) continue;
                  if( mat[x][i] >= inf ) continue;
                  if( mat[i][y] >= inf ) continue;
                  // if( mat[x][i] >= mat[x][y] ) continue;
                  // if( mat[i][y] >= mat[x][y] ) continue;
                  mat[x][y]=min(mat[x][y],mat[x][i]+mat[i][y]);
                }
              }
              // if(!change) dup++;
              // else dup = 0; 
              // if( dup>5 ) break;
            }
            for(int i=0;i<q;i++)
            {
              ll a1, a2;
              cin >>a1>>a2;
              if( mat[a1][a2] == inf ) cout<<"-1\n";
              else cout<<mat[a1][a2]<<"\n";
            }
}
